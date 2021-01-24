package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )



        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            for (shoe in shoes) {
                addShoeTextView(shoe)
            }
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer { isNavigate ->
            isNavigate?.let {
                if (isNavigate) {
                    findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                    viewModel.doneNavigatingToDetail()
                }
            }
        })

        viewModel.curUser.observe(viewLifecycleOwner, Observer { user ->
            if (user == null)
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())


        })


        return binding.root

    }

    private fun addShoeTextView(shoe: Shoe) {

        val shoeItemBinding: ItemShoeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, null, false)
        shoeItemBinding.shoe = shoe

        binding.shoeListContainer.addView(shoeItemBinding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.shoe_list_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuItem_logout -> {
                viewModel.onLogOut()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}