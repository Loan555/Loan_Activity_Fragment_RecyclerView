package com.loan555.activity_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.loan555.activity_fragment.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

const val REQEST_CODE_SIGN_UP = 1
const val REQEST_CODE_RESET_PASS = 0

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, REQEST_CODE_SIGN_UP)
        }

        btLogin.setOnClickListener {
            if (checkLogin()) {
                val mIntent = Intent(this, HomeActivity::class.java)
                startActivity(mIntent)
            } else {
                Toast.makeText(this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show()
            }
        }

        btResetPass.setOnClickListener {
            val intent = Intent(this,EmailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQEST_CODE_SIGN_UP -> {
                if (resultCode == RESULT_OK && data != null) {
                    Log.d(
                        "aaa",
                        "lay du lieu thanh cong ${data.getStringExtra("name")} | ${
                            data.getStringExtra("pass")
                        }"
                    )
                    editTextTextEmailAddress.setText(data.getStringExtra("name"))
                    editTextTextPassword.setText(data.getStringExtra("pass"))
                } else if (resultCode == RESULT_CANCELED) {
                    editTextTextEmailAddress.setText("")
                    editTextTextPassword.setText("")
                    Log.d("aaa", "huy dang ky")
                }
            }

            REQEST_CODE_RESET_PASS -> {
                if (resultCode == RESULT_OK && data != null) {
                    // reset pass ve 123
                } else if (resultCode == RESULT_CANCELED) {
                    Log.d("aaa", "huy dang ky")
                }
            }
        }
    }

    private fun checkLogin(): Boolean {
        if (editTextTextEmailAddress.text.toString() == userName && editTextTextPassword.text.toString() == password)
            return true
        return false
    }
}