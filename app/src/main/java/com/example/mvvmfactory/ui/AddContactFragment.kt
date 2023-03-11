package com.example.mvvmfactory.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.ContactViewModel
import com.example.mvvmfactory.data.Contact
import com.example.mvvmfactory.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private lateinit var binding: FragmentAddContactBinding
    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddContactBinding.inflate(inflater, container, false)

        binding.addPersonButton.setOnClickListener {
            when {
                binding.firstNameEditText.text.isNullOrEmpty() ->
                    binding.firstNameEditText.error =
                        "Error"
                binding.lastNameEditText.text.isNullOrEmpty() ->
                    binding.lastNameEditText.error =
                        "Error"
                binding.ageEditText.text.isNullOrEmpty() -> binding.ageEditText.error = "Error"
                binding.emailEditText.text.isNullOrEmpty() -> binding.emailEditText.error = "Error"
                binding.phoneNumberEditText.text.isNullOrEmpty() ->
                    binding.phoneNumberEditText.error =
                        "Error"
                binding.streetEditText.text.isNullOrEmpty() ->
                    binding.streetEditText.error =
                        "Error"
                binding.houseNumberEditText.text.isNullOrEmpty() ->
                    binding.houseNumberEditText.error =
                        "Error"
                binding.postalNumberEditText.text.isNullOrEmpty() ->
                    binding.postalNumberEditText.error =
                        "Error"
                binding.cityEditText.text.isNullOrEmpty() -> binding.cityEditText.error = "Error"
                binding.stateEditText.text.isNullOrEmpty() -> binding.stateEditText.error = "Error"
                else -> {
                    viewModel.addContact(getPersonData())
                    Log.d("Contact_Add", getPersonData().toString())
                    cleanEditText()
                }
            }
        }

        return binding.root
    }

    private fun getPersonData(): Contact = Contact(
        firstName = binding.firstNameEditText.text.toString(),
        lastName = binding.lastNameEditText.text.toString(),
        age = binding.ageEditText.text.toString(),
        email = binding.emailEditText.text.toString(),
        phoneNumber = binding.phoneNumberEditText.text.toString(),
        street = binding.streetEditText.text.toString(),
        houseNumber = binding.houseNumberEditText.text.toString(),
        postalNumber = binding.postalNumberEditText.text.toString(),
        city = binding.cityEditText.text.toString(),
        state = binding.stateEditText.text.toString(),
    )

    private fun cleanEditText() {
        with(binding) {
            firstNameEditText.text.clear()
            lastNameEditText.text.clear()
            ageEditText.text.clear()
            phoneNumberEditText.text.clear()
            emailEditText.text.clear()
            streetEditText.text.clear()
            houseNumberEditText.text.clear()
            postalNumberEditText.text.clear()
            cityEditText.text.clear()
            stateEditText.text.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroyView()
    }
}
