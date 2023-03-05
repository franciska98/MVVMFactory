package com.example.mvvmfactory.data

class ContactRepository {
    private var contacts = ArrayList<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }
    fun getContacts() = contacts
}
