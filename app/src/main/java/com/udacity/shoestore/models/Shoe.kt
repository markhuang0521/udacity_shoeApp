package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String = "",
    var size: Double = 0.0,
    var company: String = "",
    var description: String = ""
) : Parcelable {
    companion object {

        val s1 = Shoe("nick", 11.1, "nick", "cool")
        val s2 = Shoe("under", 11.1, "nick", "cool")
        val s3 = Shoe("fly", 11.1, "nick", "cool")
        val CONSTANT = mutableListOf<Shoe>(s1, s2, s3)

    }
}