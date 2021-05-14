package com.loan555.activity_fragment.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notification.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.commit {
            add<HomeFragment>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack("Home")
        }
        supportFragmentManager.commit {
            replace<NotificationFragment>(R.id.bt_notification)
            setReorderingAllowed(true)
        }

        btMenu.isSelected = true

        btMenu.setOnClickListener {
            btMenu.isSelected = true
            btCoin.isSelected = false
            btAccount.isSelected = false
            btNews.isSelected = false
            supportFragmentManager.commit {
                setCustomAnimations(R.anim.slide_in, R.anim.fade_in)
                replace<HomeFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("Home")
            }
            supportFragmentManager.commit {
                replace<NotificationFragment>(R.id.bt_notification)
                setReorderingAllowed(true)
            }
        }

        btCoin.setOnClickListener {

            btMenu.isSelected = false
            btCoin.isSelected = true
            btAccount.isSelected = false
            btNews.isSelected = false
            if (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name == "Home")
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
            supportFragmentManager.commit {
                setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                replace<CoinFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("Coin")
            }

        }

        btNews.setOnClickListener {
            btMenu.isSelected = false
            btCoin.isSelected = false
            btAccount.isSelected = false
            btNews.isSelected = true

            if (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name == "Home")
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
            supportFragmentManager.commit {
                setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                replace<NewsFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("News")
            }
        }

        btAccount.setOnClickListener {

            btMenu.isSelected = false
            btCoin.isSelected = false
            btAccount.isSelected = true
            btNews.isSelected = false
            if (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name == "Home")
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }

            supportFragmentManager.commit {
                setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                replace<MenuFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("Menu")
            }

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("aaa", "back!")

        when (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name) {
            "Home" -> {
                Log.d("aaa", "Home")
                supportFragmentManager.commit {
                    replace<NotificationFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
                btMenu.isSelected = true
                btCoin.isSelected = false
                btAccount.isSelected = false
                btNews.isSelected = false
            }
            "Coin" -> {
                Log.d("aaa", "Coin")

                btMenu.isSelected = false
                btCoin.isSelected = true
                btAccount.isSelected = false
                btNews.isSelected = false
            }
            "News" -> {
                Log.d("aaa", "News")

                btMenu.isSelected = false
                btCoin.isSelected = false
                btAccount.isSelected = false
                btNews.isSelected = true
            }
            "Menu" -> {
                Log.d("aaa", "Menu")

                btMenu.isSelected = false
                btCoin.isSelected = false
                btAccount.isSelected = true
                btNews.isSelected = false
            }
            else -> Log.d("aaa", "nothing")
        }
    }
}