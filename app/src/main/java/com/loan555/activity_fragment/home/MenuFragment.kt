package com.loan555.activity_fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.MenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    private var listData1: MutableList<Object1> = mutableListOf()
    private var listData2: MutableList<Object1> = mutableListOf()
    private var listData3: MutableList<Object1> = mutableListOf()
    private var listData4: MutableList<Object2> = mutableListOf()
    private var adapterUseViewType: MenuAdapter =
        MenuAdapter(listData1, listData2, listData3, listData4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view_type_menu.adapter = adapterUseViewType
        recycler_view_type_menu.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        listData1.add(Object1(R.drawable.iroman, "IROR MAN"))

        listData2.add(Object1(R.drawable.icons_8_alarm, "Alerts"))
        listData2.add(Object1(R.drawable.icons_8_left_and_right_arrows, "Predictions"))
        listData2.add(Object1(R.drawable.icons_8_pin, "Saved elements"))
        listData2.add(Object1(R.drawable.icons_8_no_entry, "Remove Ads"))

        listData3.add(Object1(R.drawable.icons_8_no_entry, "Tools"))

        listData3.add(Object1(R.drawable.icons_8_profit_2, "Select Stocks"))
        listData3.add(Object1(R.drawable.icons_8_swap, "Currency Exchange"))
        listData3.add(Object1(R.drawable.icons_8_video_call, "Webinar"))
        listData3.add(Object1(R.drawable.icons_8_rent, "Best Broker"))
        listData3.add(Object1(R.drawable.icons_8_no_entry, "Markets"))
        listData3.add(Object1(R.drawable.icons_8_profit, "Select Stocks"))
    }

}