package com.loan555.activity_fragment.onboarding

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.tabs.TabLayout
import com.loan555.activity_fragment.LoginActivity
import com.loan555.activity_fragment.R
import kotlinx.android.synthetic.main.activity_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboarding2.*
import kotlinx.android.synthetic.main.fragment_onboarding3.*

class OnboardingActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    val listBackStack = arrayListOf<String>("onBoarding1", "onBoarding2", "onBoarding3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_onboarding)

        supportFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out
            )
            replace<OnboardingFragment1>(R.id.fragment_container_view)
            setReorderingAllowed(true)
            addToBackStack("onBoarding1")
        }

        btNext.setOnClickListener {
            doCheckEventNext()
        }

    }

    private fun skip() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun doCheckEventNext() {
        when (supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name) {
            "onBoarding1" -> {
                supportFragmentManager.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out
                    )
                    replace<OnboardingFragment2>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                    addToBackStack("onBoarding2")
                }
            }
            "onBoarding2" -> {
                supportFragmentManager.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out
                    )
                    replace<OnboardingFragment3>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                    addToBackStack("onBoarding3")
                }
            }
            "onBoarding3" -> {
                skip()
            }
            else -> {
                supportFragmentManager.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out
                    )
                    replace<OnboardingFragment1>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                    addToBackStack("onBoarding1")
                }
            }
        }
    }
}