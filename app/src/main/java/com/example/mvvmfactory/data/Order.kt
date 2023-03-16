package com.example.mvvmfactory.data

data class Order(
    val type: TypeOfClothes,
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
        return "${type.name}, $sleeveLength, $color, $material\n" +
            "$customerName, $contactPhone, $contactEmail"
    }
}

enum class TypeOfClothes {
    BLAZER,
    BLOUSE,
    BODIE,
    SHIRT,
}
