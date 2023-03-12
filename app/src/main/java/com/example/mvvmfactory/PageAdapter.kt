package com.example.mvvmfactory

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvmfactory.ui.AddOrderFragment
import com.example.mvvmfactory.ui.OrdersFragment

class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { AddOrderFragment() }
            1 -> { OrdersFragment() }
            else -> { throw Resources.NotFoundException("Position not found") }
        }
    }
}
