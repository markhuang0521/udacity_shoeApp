package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {

    private val _shoe = MutableLiveData<Shoe?>()

    val shoe: LiveData<Shoe?>
        get() = _shoe


    fun addShoe(shoe: Shoe) {
        _shoe.value = shoe
        Shoe.CONSTANT.add(shoe)
    }
}