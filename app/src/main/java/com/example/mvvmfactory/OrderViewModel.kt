package com.example.mvvmfactory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Order

class OrderViewModel : ViewModel() {
    private var _contactsLiveData = MutableLiveData<ArrayList<Order>>(arrayListOf())
    var orderLiveData: LiveData<ArrayList<Order>> = _contactsLiveData

    fun addContact(order: Order) {
        _contactsLiveData.value = _contactsLiveData.value.also { it?.add(order) }
    }
}
