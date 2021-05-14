package com.loan555.activity_fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loan555.activity_fragment.R

class ItemAdapter(var listItem: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder1>() {

    class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tite)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_adapter1, parent, false)
        return ViewHolder1(view)
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.textView.text = listItem[position]

    }

    override fun getItemCount(): Int {
        return listItem.size
    }


}