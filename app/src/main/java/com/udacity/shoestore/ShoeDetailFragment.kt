package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        val shoe = Shoe()
        binding.newShoe = shoe


        binding.btnAddShoe.setOnClickListener {
            if (validateUserInput()) {
                viewModel.addShoe(shoe)
                viewModel.onSaveToList()

            }
        }
        binding.btnCancel.setOnClickListener {
            viewModel.onCancelToList()
        }




        viewModel.navigateToList.observe(viewLifecycleOwner, Observer { isNavigate ->
            isNavigate?.let {
                if (isNavigate || !isNavigate) {
                    findNavController().navigate(
                        ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                    )
                    viewModel.doneNavigatingToList()
                }
            }
        })



        return binding.root
    }


    private fun validateUserInput(): Boolean {

        if (binding.etShoeName.text.isNullOrEmpty()) {
            binding.etShoeName.setError("name cant be empty")
            return false
        }
        if (binding.etShoeSize.text.isNullOrEmpty()) {
            binding.etShoeCompany.setError("company cant be empty")
            return false
        }
        if (binding.etShoeDesc.text.isNullOrEmpty()) {
            binding.etShoeDesc.setError("description cant be empty")

            return false
        }
        if (binding.etShoeCompany.text.isNullOrEmpty()) {
            binding.etShoeCompany.setError("company cant be empty")
            return false
        }
        return true


    }

}