package com.example.mvvmfactory.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvmfactory.R
import com.example.mvvmfactory.data.Order
import com.example.mvvmfactory.databinding.OrderedItemViewBinding

class OrdersRecyclerAdapter(val context: Context, val ordersList: ArrayList<Order>) :
    RecyclerView.Adapter<OrdersRecyclerAdapter.OrderViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class OrderViewHolder(view: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val binding = OrderedItemViewBinding.bind(view)

        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ordered_item_view, parent, false)
        return OrderViewHolder(view, mListener)
    }

    override fun getItemCount(): Int = ordersList.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        holder.binding.apply {
            orderDataTextView.text = order.toString()
            customerDataTextView.text = order.getCustomerData()
            typeClothesImage.load(order.image)
        }
    }
}
