package com.example.mvvmfactory.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mvvmfactory.R
import com.example.mvvmfactory.databinding.ActivityMainBinding
import com.example.mvvmfactory.ui.adapter.PageAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.includeToolbar.toolbar
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)

        binding.viewPager.adapter = PageAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> { getString(R.string.add_person) }
                1 -> { getString(R.string.contacts) }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }
            }
            tab.icon = when (index) {
                0 -> { getDrawable(R.drawable.add_icon) }
                1 -> { getDrawable(R.drawable.list_icon) }
                else -> {
                    getDrawable(R.drawable.ic_launcher_background)
                }
            }
        }.attach()
    }
}
