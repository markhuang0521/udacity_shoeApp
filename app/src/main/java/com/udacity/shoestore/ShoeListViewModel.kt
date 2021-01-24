package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.User


class ShoeListViewModel : ViewModel() {


    private val _shoes = MutableLiveData<List<Shoe>>(Shoe.CONSTANT)

    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    val _user = MutableLiveData<User?>()
    val curUser: LiveData<User?>
        get() = _user


    fun addShoe(shoe: Shoe) {
        Shoe.CONSTANT.add(shoe)
        _shoes.value = Shoe.CONSTANT
    }

    private val _navigateToList = MutableLiveData<Boolean?>()
    val navigateToList: LiveData<Boolean?>
        get() = _navigateToList

    fun doneNavigatingToList() {
        _navigateToList.value = null
    }

    fun onSaveToList() {
        _navigateToList.value = true
    }

    fun onCancelToList() {
        _navigateToList.value = false
    }


    private val _navigateToDetail = MutableLiveData<Boolean>()

    val navigateToDetail: LiveData<Boolean?>
        get() = _navigateToDetail


    fun doneNavigatingToDetail() {
        _navigateToDetail.value = false
    }

    fun onClickToDetail() {
        _navigateToDetail.value = true
    }

    fun onLogOut() {
        _user.value = null
    }

    fun onCreateUser(email: String, password: String) {

        _user.value = User(email, password)

    }


}