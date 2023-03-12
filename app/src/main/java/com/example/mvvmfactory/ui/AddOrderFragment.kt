package com.example.mvvmfactory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.OrderViewModel
import com.example.mvvmfactory.data.Order
import com.example.mvvmfactory.data.TypeOfClothes
import com.example.mvvmfactory.databinding.FragmentAddOrderBinding

class AddOrderFragment : Fragment() {
    private lateinit var binding: FragmentAddOrderBinding
    private val viewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddOrderBinding.inflate(inflater, container, false)

        setSpinner()

        binding.addOrderButton.setOnClickListener {
            viewModel.addOrder(getOrderData())
            cleanData()
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

    private fun getOrderData(): Order = Order(
        type = TypeOfClothes.valueOf(binding.typeOfClothesSpinner.selectedItem.toString()),
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
        binding.sleevelessRadioButton.id -> "sleeveless"
        binding.oneRadioButton.id -> "one sleeve"
        binding.shortRadioButton.id -> "short sleeve"
        binding.longRadioButton.id -> "long sleeve"
        else -> "Not selected sleeve"
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
