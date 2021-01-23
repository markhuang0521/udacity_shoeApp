package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.User


class ShoeListViewModel : ViewModel() {


    private val _shoe = MutableLiveData<List<Shoe>>(Shoe.CONSTANT)

    val shoes: LiveData<List<Shoe>>
        get() = _shoe

    val _user = MutableLiveData<User?>()
    val curUser: LiveData<User?>
        get() = _user


    private val _navigateToDetail = MutableLiveData<Boolean>()

    val navigateToDetail: LiveData<Boolean?>
        get() = _navigateToDetail


    fun doneNavigating() {
        _navigateToDetail.value = false
    }

    fun onClickToDetail() {
        _navigateToDetail.value = true
    }

    fun setUser(user: User) {
        _user.value = user
    }

    fun onLogOut() {
        _user.value = null
    }


}