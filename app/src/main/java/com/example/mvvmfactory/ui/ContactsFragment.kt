package com.example.mvvmfactory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.ContactViewModel
import com.example.mvvmfactory.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {
    private lateinit var binding: FragmentContactsBinding
    private val viewModel: ContactViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.contactLiveData.observe(viewLifecycleOwner) { contactList ->
            val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                contactList.map { it.toString() },
            )
            binding.listView.adapter = arrayAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroyView()
    }
}
