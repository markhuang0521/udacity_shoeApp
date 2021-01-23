package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

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


        return binding.root
    }


    private fun validateUserInput(): Boolean {

        if (binding.etShoeName.text.isNullOrEmpty()) {
            binding.etShoeName.setError("name cant be empty")
            return false
        }
        if (binding.etShoeCompany.text.isNullOrEmpty()) {
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

        if (binding.etShoeImage.text.isNullOrEmpty()) {
            binding.etShoeCompany.setError("image cant be empty")

            return false
        }
        return true


    }

}