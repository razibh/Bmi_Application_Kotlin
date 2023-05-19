package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var malebtn: LinearLayout
    lateinit var btnfemale : LinearLayout
    lateinit var tvheight : TextView
    lateinit var seekber : SeekBar
    lateinit var tvage : TextView
    lateinit var tvweight : TextView
    lateinit var btnweightplus : FloatingActionButton
    lateinit var btnweightmin : FloatingActionButton
    lateinit var ageweightplus : FloatingActionButton
    lateinit var ageweightmin : FloatingActionButton
    lateinit var btnclculate: Button
     var weight = 1;
    var age = 1; var height =1;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        malebtn = findViewById(R.id.btnmale)
        btnfemale = findViewById(R.id.btnfemale)
        tvheight = findViewById(R.id.btnheight)
        seekber = findViewById(R.id.seekbarid)
        tvage = findViewById(R.id.btnage)
        tvweight = findViewById(R.id.btnweight)
        btnweightplus = findViewById(R.id.btnincr)
        btnweightmin = findViewById(R.id.btndecr)
        ageweightplus = findViewById(R.id.btnageinc)
        ageweightmin = findViewById(R.id.btnagedec)
        btnclculate= findViewById(R.id.btncal)

        malebtn.setOnClickListener{
            malebtn.setBackgroundColor(Color.parseColor("#0000ff"))

        }
        btnfemale.setOnClickListener{
            btnfemale.setBackgroundColor(Color.parseColor("#ff0000"))

        }
        seekber.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                height = progress
                tvheight.text = "$progress cm"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        btnweightplus.setOnClickListener{
          weight++
            tvweight.text= weight.toString()
        }
        btnweightmin.setOnClickListener{
           if (1 < weight) weight--
            tvweight.text= weight.toString()
        }
        ageweightplus.setOnClickListener{
            age++
            tvage.text= age.toString()
        }
        ageweightmin.setOnClickListener{
            if (1 < age) age--
            tvage.text= age.toString()
        }
       btnclculate.setOnClickListener{
           bmiCalculation(height,weight)
       }
    }
    fun bmiCalculation(height: Int, weight:Int) {
        var mheight = Math.pow((height / 100).toDouble(), 2.toDouble())
        var bmi = weight / mheight

        val intent = Intent(this, result::class.java)
        intent.putExtra("bmi_result", String.format("%.2f", bmi))
        startActivity(intent)
    }
}
