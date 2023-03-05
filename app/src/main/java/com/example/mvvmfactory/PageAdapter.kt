package com.example.mvvmfactory

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvmfactory.ui.AddContactFragment
import com.example.mvvmfactory.ui.ContactsFragment

class PageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { AddContactFragment() }
            1 -> { ContactsFragment() }
            else -> { throw Resources.NotFoundException("Position not found") }
        }
    }
}
