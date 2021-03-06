package com.loan555.activity_fragment.home.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.News

class NewsAdapter (var listItem: ArrayList<News>,val listener: OnItemClickListener) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val title1: TextView = itemView.findViewById(R.id.title1)
        val image : ImageView = itemView.findViewById(R.id.image)
        val contentTitle: TextView = itemView.findViewById(R.id.content_title)
        val contentNews: TextView = itemView.findViewById(R.id.content_news)
        val timeTitle: TextView = itemView.findViewById(R.id.time_tite)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = layoutPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.image.setImageResource(listItem[position].img)
        holder.title1.text = listItem[position].title1
        holder.contentNews.text = listItem[position].contentNews
        holder.contentTitle.text = listItem[position].contentTitle
        holder.timeTitle.text = listItem[position].timeTitle
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}