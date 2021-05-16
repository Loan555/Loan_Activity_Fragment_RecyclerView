package com.loan555.activity_fragment.home

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceControl
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.loan555.activity_fragment.R
import com.loan555.activity_fragment.home.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notification.*

class HomeActivity : AppCompatActivity() {

    var msg: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.fragment_container_view_home)
            setReorderingAllowed(true)
            addToBackStack("Home")
        }
        supportFragmentManager.commit {
            replace<NotificationFragment>(R.id.bt_notification)
            setReorderingAllowed(true)
        }
        checkBackStack()

        btMenu.isSelected = true

        btMenu.setOnClickListener {
            btMenu.isSelected = true
            btCoin.isSelected = false
            btAccount.isSelected = false
            btNews.isSelected = false

            checkBackStack("Home")
//            supportFragmentManager.commit {
//                setCustomAnimations(R.anim.slide_in, R.anim.fade_in)
//                replace<HomeFragment>(R.id.fragment_container_view_home)
//                setReorderingAllowed(true)
//                addToBackStack("Home")
//            }
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
                replace<CoinFragment>(R.id.fragment_container_view_home)
                setReorderingAllowed(true)
                addToBackStack("Coin")
            }
            checkBackStack()
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
                replace<NewsFragment>(R.id.fragment_container_view_home)
                setReorderingAllowed(true)
                addToBackStack("News")
            }
            checkBackStack()
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
                replace<MenuFragment>(R.id.fragment_container_view_home)
                setReorderingAllowed(true)
                addToBackStack("Menu")
            }
            checkBackStack()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("aaa", "back!")
        if (supportFragmentManager.backStackEntryCount > 0) {
            checkStateBar()
            checkBackStack()
        } else showDialog("Exittttttt ?")
    }

    private fun checkStateBar() {
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
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
                btMenu.isSelected = false
                btCoin.isSelected = true
                btAccount.isSelected = false
                btNews.isSelected = false
            }
            "News" -> {
                Log.d("aaa", "News")
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
                btMenu.isSelected = false
                btCoin.isSelected = false
                btAccount.isSelected = false
                btNews.isSelected = true
            }
            "Menu" -> {
                Log.d("aaa", "Menu")
                supportFragmentManager.commit {
                    replace<BlankFragment>(R.id.bt_notification)
                    setReorderingAllowed(true)
                }
                btMenu.isSelected = false
                btCoin.isSelected = false
                btAccount.isSelected = true
                btNews.isSelected = false
            }
            "Detail_home" -> {
                supportFragmentManager.popBackStack()
            }
            else -> Log.d("aaa", "nothing")
        }
    }

    private fun checkBackStack() {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            Log.d("backStack", "back Stack= ${supportFragmentManager.getBackStackEntryAt(i).name}")
        }
    }

    private fun checkBackStack(string: String) {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            if (supportFragmentManager.getBackStackEntryAt(i).name == string) {
                supportFragmentManager.popBackStack(string, 0)
                break
            }
        }
        checkBackStack()
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_layout)
        val body = dialog.findViewById(R.id.body) as TextView
        body.text = title
        val yesBtn = dialog.findViewById(R.id.yesBtn) as TextView
        val noBtn = dialog.findViewById(R.id.noBtn) as TextView
        yesBtn.setOnClickListener {
            finish()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
            supportFragmentManager.commit {
                replace<HomeFragment>(R.id.fragment_container_view_home)
                setReorderingAllowed(true)
                addToBackStack("Home")
            }
        }
        dialog.show()

    }

}