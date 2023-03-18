package com.example.mvvmfactory.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mvvmfactory.R
import com.example.mvvmfactory.databinding.ActivityOrderDetailBinding

class OrderDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.includeToolbar.toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }
}
