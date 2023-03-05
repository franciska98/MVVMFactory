package com.example.mvvmfactory

import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Contact

class ContactViewModel : ViewModel() {
    private var contacts = ArrayList<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }
    fun getContacts() = contacts

    override fun onCleared() {
        super.onCleared()
    }
}
