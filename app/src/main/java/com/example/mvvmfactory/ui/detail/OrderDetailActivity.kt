package com.example.mvvmfactory.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import coil.load
import com.example.mvvmfactory.R
import com.example.mvvmfactory.data.Order
import com.example.mvvmfactory.databinding.ActivityOrderDetailBinding
import com.google.android.material.appbar.CollapsingToolbarLayout

class OrderDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: CollapsingToolbarLayout = binding.collapsingToolbarLayout
        toolbar.title = getString(R.string.order)
        toolbar.setExpandedTitleColor(getColor(R.color.dark_pink))

        val order = intent.getSerializableExtra("order") as? Order
        if (order != null) {
            with(binding) {
                expandedImage.load(order.image)
                orderDetailLayout.customerNameDetailTextView.text = order.customerName
                orderDetailLayout.contactEmailDetailTextView.text = order.contactEmail
                orderDetailLayout.contactPhoneDetailTextView.text = order.contactPhone
                orderDetailLayout.typeDetailTextView.text = order.type.name
                orderDetailLayout.colorDetailTextView.text = order.color
                orderDetailLayout.materialDetailTextView.text = order.material
                orderDetailLayout.sleeveDetailTextView.text = order.sleeveLength
                orderDetailLayout.bustDetailTextView.text = order.bust
                orderDetailLayout.weistDetailTextView.text = order.weist
                orderDetailLayout.hipDetailTextView.text = order.hip
                orderDetailLayout.shoulderDetailTextView.text = order.shoulderLength
            }
        }
    }
}
