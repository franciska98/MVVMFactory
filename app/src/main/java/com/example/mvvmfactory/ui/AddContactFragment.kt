package com.example.mvvmfactory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmfactory.ContactViewModel
import com.example.mvvmfactory.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContactViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}
