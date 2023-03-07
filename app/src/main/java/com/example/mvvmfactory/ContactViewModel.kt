package com.example.mvvmfactory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmfactory.data.Contact

class ContactViewModel : ViewModel() {
    //    private var contacts = ArrayList<Contact>()
    private var _contactsLiveData = MutableLiveData<ArrayList<Contact>>(arrayListOf())
    var contactLiveData: LiveData<ArrayList<Contact>> = _contactsLiveData

    fun addContact(contact: Contact) {
//        contacts.add(contact)
        Log.d("Contact_addViewModel", contact.toString())
        _contactsLiveData.value = _contactsLiveData.value.also { it?.add(contact) }
    }

//    fun getDataForPrint(): ArrayList<String> {
//        val list = ArrayList<String>()
//        for (contact in contacts) {
//            list.add(contact.toString())
//            Log.d("Contact_getViewModel", contact.toString())
//        }
//        return list
//    }
}
