package com.loan555.activity_fragment.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loan555.activity_fragment.LoginActivity
import com.loan555.activity_fragment.R
import kotlinx.android.synthetic.main.fragment_onboarding1.*
import kotlinx.android.synthetic.main.fragment_onboarding2.*
import kotlinx.android.synthetic.main.fragment_onboarding2.txtSkip

class OnboardingFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtSkip.setOnClickListener {
            activity?.finish()
            startActivity(Intent(activity, LoginActivity::class.java))
        }

        backSpace.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

}