package com.loan555.activity_fragment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
var userName: String = "loan"
var password: String = "123"

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btSignUp.setOnClickListener {
            val mail = editTextTextEmailAddress.text.toString()
            val pass = editTextTextPassword.text.toString()

            if (mail != "" && pass != "") {
                userName = mail
                password = pass
                val data = Intent()
                data.putExtra("name", userName)
                data.putExtra("pass", password)
                setResult(Activity.RESULT_OK, data)
                Log.d("aaa", "aaaaaaaaa: $userName | $password |code ${Activity.RESULT_OK}")
                finish()
            } else if (mail == "")
                Toast.makeText(this, "Mail is mustn't null!", Toast.LENGTH_SHORT).show()
            else if (pass == "")
                Toast.makeText(this, "Mail is mustn't null!", Toast.LENGTH_SHORT).show()
        }
    }
}