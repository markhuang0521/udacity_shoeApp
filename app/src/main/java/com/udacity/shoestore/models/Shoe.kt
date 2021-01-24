package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    @Bindable
    var name: String = "",
    @Bindable
    var size: Double = 0.0,
    @Bindable
    var company: String = "",
    @Bindable
    var description: String = ""
) : Parcelable, BaseObservable() {
    companion object {

        val s1 = Shoe("nick", 11.1, "nick", "cool")
        val s2 = Shoe("under", 11.1, "nick", "cool")
        val s3 = Shoe("fly", 11.1, "nick", "cool")
        val s4 = Shoe()
        val CONSTANT = mutableListOf<Shoe>(s1, s2, s3, s4)

    }
}