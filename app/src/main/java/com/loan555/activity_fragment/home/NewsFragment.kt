package com.loan555.activity_fragment.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.ItemAdapter
import com.loan555.activity_fragment.home.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(), NewsAdapter.OnItemClickListener {

    private lateinit var menuList: ArrayList<String>
    private lateinit var newsList: ArrayList<News>
    private lateinit var newAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMenu()
        initNewsList()

    }

    private fun initMenu() {
        initData()

        recycler_view_menu.adapter = ItemAdapter(menuList)
        recycler_view_menu.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun initNewsList() {

        newAdapter = NewsAdapter(newsList, this)
        recycler_view_news.adapter = newAdapter
        recycler_view_news.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        menuList = ArrayList<String>()
        menuList.add("EDITORIAL")
        menuList.add("CRYPTO NEWS")
        menuList.add("RAW MATERIAL")
        menuList.add("ECONOMICS")

        var news1 = News(
            R.drawable.img2390177,
            "ALT -3,87%",
            "ATLANTIA",
            "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus",
            "3 Sept 2020"
        )
        newsList = ArrayList<News>()
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
        newsList.add(news1)
    }

    override fun onItemClick(position: Int) {
        Log.d("aaa", newsList[position].contentTitle)
        this.activity?.intent?.putExtra("TITLE",newsList[position].contentTitle)
        activity?.supportFragmentManager?.commit {
            replace<NewsDetailFragment>(R.id.fragment_container_view_home)
            addToBackStack("Detail_home")
        }
    }

}