package com.example.mvvmfactory

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Contact

class ContactViewModel : ViewModel() {
    private var contacts = ArrayList<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
        Log.d("Contact_addViewModel", contact.toString())
    }

    fun getDataForPrint(): ArrayList<String> {
        val list = ArrayList<String>()
        for (contact in contacts) {
            list.add(contact.toString())
            Log.d("Contact_getViewModel", contact.toString())
        }
        return list
    }
}
