package com.brad.testlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_count.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            btn_count.id -> {
                if (et_height.text.isNotEmpty() && et_weight.text.isNotEmpty()){
                    val height = et_height.text.toString().toDouble()
                    val weight = et_weight.text.toString().toDouble()
                    val bmi = weight / height.pow(2)*10000
                    tv_bmi.text = "BMI:%.1f".format(bmi)
                }
            }

        }
    }

}