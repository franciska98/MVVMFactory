package com.example.mvvmfactory.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.databinding.FragmentOrdersBinding
import com.example.mvvmfactory.ui.adapter.OrdersRecyclerAdapter
import com.example.mvvmfactory.ui.viewmodel.OrderViewModel

class OrdersFragment : Fragment() {
    private lateinit var binding: FragmentOrdersBinding
    private val viewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.orderLiveData.observe(viewLifecycleOwner) { contactList ->
            binding.recyclerView.adapter = OrdersRecyclerAdapter(requireContext(), contactList)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroyView()
    }
}
