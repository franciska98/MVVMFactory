package com.example.mvvmfactory.ui.main.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mvvmfactory.data.Order
import com.example.mvvmfactory.data.TypeOfClothes
import com.example.mvvmfactory.databinding.FragmentOrdersBinding
import com.example.mvvmfactory.ui.main.adapter.OrdersRecyclerAdapter
import com.example.mvvmfactory.ui.main.viewmodel.OrderViewModel

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

        fillRecyclerView()
        viewModel.orderLiveData.observe(viewLifecycleOwner) { orderList ->
            binding.recyclerView.adapter = OrdersRecyclerAdapter(requireContext(), orderList)
        }
    }

    private fun fillRecyclerView() {
        viewModel.addOrder(
            Order(
                TypeOfClothes.SHIRT, TypeOfClothes.SHIRT.image, "98", "65", "100",
                "12", "Sleeveless", "red", "cotton",
                "Petra Petric", "petra.petric@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.PULLOVER, TypeOfClothes.PULLOVER.image, "95", "60", "99",
                "10", "Long sleeve", "blue", "wool",
                "Sara Petric", "sara.petric@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.BLAZER, TypeOfClothes.BLAZER.image, "80", "65", "99",
                "15", "Short sleeve", "black", "leather",
                "Sara Ivic", "sara.ivic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.BLOUSE, TypeOfClothes.BLOUSE.image, "88", "65", "89",
                "16", "One sleeve", "pink", "silk",
                "Lara Ivic", "lara.ivic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.SHIRT, TypeOfClothes.SHIRT.image, "101", "80", "100",
                "18", "Short sleeve", "white", "polyester",
                "Lara Anic", "lara.anic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.PULLOVER, TypeOfClothes.PULLOVER.image, "88", "65", "89",
                "16", "Long sleeve", "purple", "wool",
                "Lara Ivic", "lara.ivic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.BLOUSE, TypeOfClothes.BLOUSE.image, "80", "65", "99",
                "15", "One sleeve", "yellow", "silk",
                "Sara Ivic", "sara.ivic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.BLAZER, TypeOfClothes.BLAZER.image, "98", "65", "100",
                "12", "Sleeveless", "black", "polyester",
                "Petra Petric", "petra.petric@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.SHIRT, TypeOfClothes.SHIRT.image, "87", "70", "90",
                "15", "One sleeve", "red", "leather",
                "Ana Anic", "ana.anic@gmail.com", "0951235555",
            ),
        )
        viewModel.addOrder(
            Order(
                TypeOfClothes.BLAZER, TypeOfClothes.BLAZER.image, "87", "70", "90",
                "15", "Long sleeve", "blue", "cotton",
                "Ana Anic", "ana.anic@gmail.com", "0951235555",
            ),
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        super.onDestroyView()
    }
}
