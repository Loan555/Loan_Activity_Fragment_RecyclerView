package com.loan555.activity_fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.ItemAdapter
import com.loan555.activity_fragment.home.adapter.ProductAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var listProduct: ArrayList<Product>
    private lateinit var listProductView: ArrayList<Product>
    private lateinit var listTite: ArrayList<String>
    private lateinit var adapterProduct: ProductAdapter

    lateinit var adapterMenu: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()

        adapterMenu = ItemAdapter(listTite)
        rowTite.adapter = adapterMenu
        rowTite.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        Log.d("aaa", "tong list" + listTite.size.toString())

        adapterProduct = ProductAdapter(listProductView)
        list_product_view.adapter = adapterProduct
        list_product_view.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        list_product_view.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )

        var itemTouchHelper: ItemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.DOWN or ItemTouchHelper.UP,
                ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                adapterProduct.notifyItemMoved(viewHolder.layoutPosition, target.layoutPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var positionOfData = viewHolder.layoutPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        listProduct.removeAt(positionOfData)
                        listProductView.removeAt(positionOfData)
                        adapterProduct.notifyItemRemoved(viewHolder.layoutPosition)
                    }
                    ItemTouchHelper.RIGHT -> {
                        listProduct.removeAt(positionOfData)
                        listProductView.removeAt(positionOfData)
                        adapterProduct.notifyItemRemoved(viewHolder.layoutPosition)
                    }

                }
            }
        })
        itemTouchHelper.attachToRecyclerView(list_product_view)
        bt_add_more.setOnClickListener {
            addMore()
            adapterProduct.notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun initData() {
        listTite = ArrayList<String>()
        listTite.add("INDEX")
        listTite.add("SHARES")
        listTite.add("CURRENCIES")
        listTite.add("FUTURES")
        listTite.add("CRYPTO")

        var product1 = Product("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)")
        listProduct = ArrayList<Product>()
        listProductView = ArrayList<Product>()
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        listProduct.add(Product("DOWN JONES + ${listProduct.size}", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))

        addMore()
        Log.d("aaa","list sum = ${listProduct.size}")
    }

    fun addMore(){
        var count: Int = 0
        while (listProduct.size > listProductView.size && count < 5) {
            listProductView.add(listProduct.get(listProductView.size))
            count++
        }
    }

}