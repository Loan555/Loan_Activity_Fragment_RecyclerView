package com.loan555.activity_fragment.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.loan555.activity_fragment.LoginActivity
import com.loan555.activity_fragment.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppPreferences.init(this)
        if (!AppPreferences.firstRun) {
//            AppPreferences.firstRun = true
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
            Log.d("SpinKotlin", "The value of our pref is: ${AppPreferences.firstRun}")
        } else {
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

object AppPreferences {
    private const val NAME = "SpinKotlin"
    private const val MODE = Context.MODE_PRIVATE
    lateinit var preferences: SharedPreferences

    private val IS_FIRST_RUN_PREF = Pair("is_first_run", true)
    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstRun: Boolean
        // custom getter to get a preference of a desired type, with a predefined default value
        get() = preferences.getBoolean(IS_FIRST_RUN_PREF.first, IS_FIRST_RUN_PREF.second)
        // custom setter to save a preference back to preferences file
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST_RUN_PREF.first, value)
        }
}