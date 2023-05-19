package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class result : AppCompatActivity() {
    lateinit var tv_head: TextView
    lateinit var tv_res : TextView
    lateinit var tv_trips : TextView
    lateinit var btn_res : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmiResult = intent.getStringExtra("bmi_result")?.toDouble()

        tv_head = findViewById(R.id.tvhead)
        tv_res = findViewById(R.id.tvres)
        tv_trips = findViewById(R.id.tvtrips)
        btn_res = findViewById(R.id.btnres)

        tv_res.text = bmiResult.toString()

        if (bmiResult != null){
            if (bmiResult <= 18.4){
                tv_head.text= "You are underweight"
                tv_res.text= "BMI is $bmiResult"
                tv_trips.text=" Eat more food and gain weight"
            }
             else if (bmiResult >= 18.5 && bmiResult <=24.9){
                tv_head.text= "You are Normal"
                tv_res.text= "BMI is $bmiResult"
                tv_trips.text=" Nothing to do ,enjoy your life"
            }
            else if (bmiResult >= 25 ){
                tv_head.text= "You are overweight"
                tv_res.text= "BMI is $bmiResult"
                tv_trips.text=" Choice your dietplan and do exercise "
            }
        }
        btn_res.setOnClickListener {
            finish()
        }
    }
}