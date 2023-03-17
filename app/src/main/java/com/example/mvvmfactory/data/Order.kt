package com.example.mvvmfactory.data

import com.example.mvvmfactory.R

data class Order(
    val type: TypeOfClothes,
    val image: Int,
    val bust: String,
    val weist: String,
    val hip: String,
    val shoulderLength: String,
    val sleeveLength: String,
    val color: String,
    val material: String,
    val customerName: String,
    val contactEmail: String,
    val contactPhone: String,
) {
    override fun toString(): String {
        return "$color, $material, $sleeveLength"
    }

    fun getCustomerData(): String {
        return "$customerName, $contactPhone, $contactEmail"
    }
}

enum class TypeOfClothes(val image: Int) {
    BLAZER(R.drawable.blazer),
    BLOUSE(R.drawable.blouse),
    PULLOVER(R.drawable.pullover),
    SHIRT(R.drawable.shirt),
}
