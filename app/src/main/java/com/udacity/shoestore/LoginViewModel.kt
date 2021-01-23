package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.User


class LoginViewModel : ViewModel() {

    private val _user = MutableLiveData<User?>()

    val user: LiveData<User?>
        get() = _user


    fun onCreateUser(email: String, password: String) {

        _user.value = User(email, password)

    }


}