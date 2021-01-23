package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    lateinit var viewModel: ShoeListViewModel

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

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        val args = WelcomeFragmentArgs.fromBundle(arguments!!)
        viewModel.setUser(args.user)

        binding.viewmodel = viewModel
        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            for (shoe in shoes) {
                addShoeTextView(shoe)
            }
        })

        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer { isNavigate ->
            isNavigate?.let {
                if (isNavigate) {
                    findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                }
            }
        })

        viewModel.curUser.observe(viewLifecycleOwner, Observer { user ->
            if (user == null)
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())


        })




        return binding.root

        // Inflate the layout for this fragment
    }

    private fun addShoeTextView(shoe: Shoe) {
        val textview = TextView(activity)

        textview.text =
            "Shoe Item: \n  Name: ${shoe.name}\n Size: ${shoe.size} \n Comapny: ${shoe.company}\n  description: ${shoe.description}\n"

        textview.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        binding.shoeListContainer.addView(textview)


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