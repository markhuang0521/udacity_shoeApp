package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        val viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            if (validateUserInput()) {
                viewModel.onCreateUser(
                    binding.etUserEmail.text.toString(),
                    binding.etUserPassword.text.toString()
                )
            }
        }
        binding.btnSignIn.setOnClickListener {
            if (validateUserInput()) {
                viewModel.onCreateUser(
                    binding.etUserEmail.text.toString(),
                    binding.etUserPassword.text.toString()
                )
            }
        }

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            user?.let {

                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(user)
                )
            }
        })

        return binding.root
    }


    private fun validateUserInput(): Boolean {

        if (binding.etUserEmail.text.isNullOrEmpty()) {
            binding.etUserEmail.setError("email cant be empty")
            return false
        }
        if (binding.etUserPassword.text.isNullOrEmpty()) {
            binding.etUserPassword.setError("password cant be empty")

            return false
        }
        return true


    }

}