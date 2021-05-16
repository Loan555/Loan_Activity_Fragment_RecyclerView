package com.loan555.activity_fragment.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.Object1
import com.loan555.activity_fragment.home.Object2

class MenuAdapter(
    private var list: MutableList<Object1>,
    private var list2: MutableList<Object1>,
    private var list3: MutableList<Object1>,
    private var list4: MutableList<Object2>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var countList: Int = 0

    inner class ViewTypeViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, reSrcId: Int) {
            val imgView1: ImageView = itemView.findViewById(R.id.img_avatar)
            val textView1: TextView = itemView.findViewById(R.id.name_account)
            imgView1.setImageResource(reSrcId)
            textView1.text = text
        }
    }

    inner class ViewTypeViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, reSrcId: Int) {
            val imgView2: ImageView = itemView.findViewById(R.id.icon)
            val textView2: TextView = itemView.findViewById(R.id.name_icon)
            imgView2.setImageResource(reSrcId)
            textView2.text = text
        }
    }

    inner class ViewTypeViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, reSrcId: Int) {
            val imgView2: ImageView = itemView.findViewById(R.id.m_icon)
            val textView2: TextView = itemView.findViewById(R.id.m_name_icon)
            imgView2.setImageResource(reSrcId)
            textView2.text = text
        }
    }

    inner class ViewTypeViewHolder4(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            val textView: TextView = itemView.findViewById(R.id.name_menu)
            textView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.TYPE_1.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.acount_adapter, parent, false)
                ViewTypeViewHolder1(view)
            }
            ViewType.TYPE_2.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.acount_menu1_adapter, parent, false)
                ViewTypeViewHolder2(view)
            }
            ViewType.TYPE_4.type -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.account_menu2_adapter, parent, false)
                ViewTypeViewHolder4(view)
            }
            else -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.account_menu3_adapter, parent, false)
                ViewTypeViewHolder3(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewTypeViewHolder1 -> holder.bind(
                list[position].txt,
                list[position].image
            )
            is ViewTypeViewHolder2 -> holder.bind(
                list2[position - list.size].txt,
                list2[position - list.size].image
            )
            is ViewTypeViewHolder3 -> holder.bind(
                list3[position - list.size - list2.size].txt,
                list3[position - list.size - list2.size].image
            )
            is ViewTypeViewHolder4 -> holder.bind(
                list3[position - list.size - list2.size].txt
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size + list2.size + list3.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until list.size -> ViewType.TYPE_1.type
            in list.size until list.size + list2.size -> ViewType.TYPE_2.type
            5,10 ->ViewType.TYPE_4.type
            else -> ViewType.TYPE_3.type
        }
    }

    enum class ViewType(val type: Int) {
        TYPE_1(0),
        TYPE_2(1),
        TYPE_3(2),
        TYPE_4(3)
    }
}