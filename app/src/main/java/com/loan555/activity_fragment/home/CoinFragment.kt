package com.loan555.activity_fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.ItemAdapter
import kotlinx.android.synthetic.main.fragment_coin.*

class CoinFragment : Fragment() {

    private lateinit var listTite2: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMenu()
    }

    private fun initMenu() {
        initData()
        row_menu.adapter = ItemAdapter(listTite2)
        row_menu.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun initData() {
        listTite2 = ArrayList<String>()
        listTite2.add("General")
        listTite2.add("Technical Section")
        listTite2.add("Markets")
        listTite2.add("Charts")
    }
}