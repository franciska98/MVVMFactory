package com.example.mvvmfactory.data

data class Order(
    val firstName: String,
    val lastName: String,
    val age: String,
    val email: String,
    val phoneNumber: String,
    val street: String,
    val houseNumber: String,
    val postalNumber: String,
    val city: String,
    val state: String,
) {
    override fun toString(): String {
        return "$firstName $lastName, $age, $city, $state"
    }
}
