package com.example.mvvmfactory.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Order

class OrderViewModel : ViewModel() {
    private var _ordersLiveData = MutableLiveData<ArrayList<Order>>(arrayListOf())
    var orderLiveData: LiveData<ArrayList<Order>> = _ordersLiveData

    fun addOrder(order: Order) {
        _ordersLiveData.value = _ordersLiveData.value.also { it?.add(order) }
    }
}
