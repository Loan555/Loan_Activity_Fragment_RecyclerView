package com.loan555.activity_fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.Product

class ProductAdapter(var listProduct: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name1: TextView = itemView.findViewById(R.id.name)
        val address: TextView = itemView.findViewById(R.id.address)
        val time: TextView = itemView.findViewById(R.id.time)
        val value1: TextView = itemView.findViewById(R.id.value1)
        val value2: TextView = itemView.findViewById(R.id.value2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name1.text = listProduct[position].name
        holder.address.text = listProduct[position].address
        holder.time.text = listProduct[position].time
        holder.value1.text = listProduct[position].value1
        holder.value2.text = listProduct[position].value2
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

}
