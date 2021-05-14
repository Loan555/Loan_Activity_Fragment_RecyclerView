package com.loan555.activity_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import kotlinx.android.synthetic.main.activity_email.*
import kotlin.concurrent.thread

class EmailActivity : AppCompatActivity() {

    var count: Int = 0
    lateinit var mHandler: Handler
    var maxThreadResetCount: Int = 0
    var resetPass: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        mHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    1001 -> {
                        var str = "Wait ${msg.arg1} seconds before sending it"
                        countNumber.text = str
                    }
                    1002 -> {
                        if (msg.arg1 == 1) {
                            doOpen()
                            Log.d("aaa", "resetpass thanh cong")
                        }
                    }
                }
            }
        }

        btResendMail.setOnClickListener {
            maxThreadResetCount++
            doCountDown()
        }

    }

    fun doOpen() {
        val mIntent = Intent(this, ChangedActivity::class.java)
        resetPass = 0
        finish()
        startActivity(mIntent)
    }

    private fun doCountDown() {
        count = 30
        var mThread = Thread(Runnable {
            var idThread: Int = maxThreadResetCount
            while (maxThreadResetCount == idThread && count > 0) {
                Thread.sleep(1000)
                count--
                var message = Message()
                message.what = 1001
                message.arg1 = count
                mHandler.sendMessage(message)
                Log.d("aaa", "$count")
            }
            if (count <= 0) {
                Log.d("aaa", "ket thuc dem nguoc!")
                //thay doi mat khau o day
                password = "123"
                resetPass = 1
                var message = Message()
                message.what = 1002
                message.arg1 = resetPass
                mHandler.sendMessage(message)
            }
        })
        mThread.start()

    }
}