package com.example.mvvmfactory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Contact

class ContactViewModel : ViewModel() {
    private var _contactsLiveData = MutableLiveData<ArrayList<Contact>>(arrayListOf())
    var contactLiveData: LiveData<ArrayList<Contact>> = _contactsLiveData

    fun addContact(contact: Contact) {
        _contactsLiveData.value = _contactsLiveData.value.also { it?.add(contact) }
    }
}
