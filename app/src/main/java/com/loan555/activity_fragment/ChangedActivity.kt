package com.loan555.activity_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_changed.*

class ChangedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changed)

        btLogin.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(mIntent)
        }
    }
}