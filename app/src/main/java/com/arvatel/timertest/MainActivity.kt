package com.arvatel.timertest

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        object : CountDownTimer(180L * 24 * 60 * 60 * 1000, 1000) {
        object : CountDownTimer(60 * 60 * 1000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished % (60 * 1000) / 1000
                val minute = millisUntilFinished % (60 * 60 * 1000) / (60 * 1000)
                val hour = millisUntilFinished % (24 * 60 * 60 * 1000) / (60 * 60 * 1000)
                val day = millisUntilFinished / (24 * 60 * 60 * 1000)
                textTime.text = "${day}D:${hour}H:${minute}M:${second}S"
                textTime2.text = "${day}:${hour}:${minute}:${second}"
            }

            override fun onFinish() {
                textTime.text = "done!"
            }
        }.start()

    }


}
