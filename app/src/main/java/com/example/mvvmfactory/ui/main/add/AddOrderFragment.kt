package com.example.mvvmfactory.ui.main.add

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.R
import com.example.mvvmfactory.data.Order
import com.example.mvvmfactory.data.TypeOfClothes
import com.example.mvvmfactory.databinding.FragmentAddOrderBinding
import com.example.mvvmfactory.ui.main.viewmodel.OrderViewModel
import com.google.android.material.snackbar.Snackbar

class AddOrderFragment : Fragment() {
    private lateinit var binding: FragmentAddOrderBinding
    private val viewModel: OrderViewModel by activityViewModels()
    private var emptyFields: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddOrderBinding.inflate(inflater, container, false)

        setSpinner()

        binding.addOrderButton.setOnClickListener {
            validateEmptyEdittext()
            if (emptyFields == 0) {
                when {
                    !validSize(binding.bustEditText.text.toString()) ->
                        binding.bustEditText.error = getString(R.string.error_invalid_size)
                    !validSize(binding.weistEditText.text.toString()) ->
                        binding.weistEditText.error = getString(R.string.error_invalid_size)
                    !validSize(binding.hipEditText.text.toString()) ->
                        binding.hipEditText.error = getString(R.string.error_invalid_size)
                    !validShoulderLength(binding.shoulderLengthEditText.text.toString()) ->
                        binding.shoulderLengthEditText.error =
                            getString(R.string.error_invalid_size)
                    !validEmail(binding.contactEmailEditText.text.toString()) ->
                        binding.contactEmailEditText.error = getString(R.string.error_invalid_email)
                    !validPhone(binding.contactPhoneEditText.text.toString()) ->
                        binding.contactPhoneEditText.error = getString(R.string.error_invalid_phone)
                    else -> {
                        viewModel.addOrder(getOrderData())
                        cleanData()
                        Snackbar.make(it, R.string.snackbar_message, Snackbar.LENGTH_SHORT)
                            .setAction(R.string.snackbar_undo_option) {
                                viewModel.removeLastOrder()
                            }.show()
                    }
                }
            }
        }

        return binding.root
    }

    private fun setSpinner() {
        val typeList = TypeOfClothes.values().map { it.toString() }
        val adapterSpinner = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            typeList,
        )
        binding.typeOfClothesSpinner.adapter = adapterSpinner
    }

    private fun validateEmptyEdittext() {
        emptyFields = 0
        binding.dataContainer.children.filterIsInstance<EditText>().forEach {
            if (it.emptyValidation()) {
                it.error = getString(R.string.error_empty_field)
                emptyFields++
            }
        }
    }

    private fun EditText.emptyValidation(): Boolean = text.isNullOrEmpty()

    private fun validSize(size: String): Boolean = (size.length == 2 || size.length == 3)

    private fun validShoulderLength(size: String): Boolean = (size.length == 1 || size.length == 2)

    private fun validEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun validPhone(phone: String): Boolean = phone.length == 10

    private fun getOrderData(): Order = Order(
        type = TypeOfClothes.valueOf(binding.typeOfClothesSpinner.selectedItem.toString()),
        image = TypeOfClothes.valueOf(binding.typeOfClothesSpinner.selectedItem.toString()).image,
        bust = binding.bustEditText.text.toString(),
        weist = binding.weistEditText.text.toString(),
        hip = binding.hipEditText.text.toString(),
        shoulderLength = binding.shoulderLengthEditText.text.toString(),
        sleeveLength = getTextFromRadioButton(binding.sleeveRadioGroup.checkedRadioButtonId),
        color = binding.colorEditText.text.toString(),
        material = binding.materialEditText.text.toString(),
        customerName = binding.customerNameEditText.text.toString(),
        contactEmail = binding.contactEmailEditText.text.toString(),
        contactPhone = binding.contactPhoneEditText.text.toString(),
    )

    private fun getTextFromRadioButton(id: Int): String = when (id) {
        binding.sleevelessRadioButton.id -> getString(R.string.sleeve_option_sleeveless)
        binding.oneRadioButton.id -> getString(R.string.sleeve_option_one)
        binding.shortRadioButton.id -> getString(R.string.sleeve_option_short)
        binding.longRadioButton.id -> getString(R.string.sleeve_option_long)
        else -> getString(R.string.sleeve_option_nothing_selected)
    }

    private fun cleanData() {
        with(binding) {
            dataContainer.children.filterIsInstance<EditText>().forEach { it.text.clear() }
            sleeveRadioGroup.clearCheck()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroyView()
    }
}
