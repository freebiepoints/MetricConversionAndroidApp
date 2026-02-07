package com.example.metricconversion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var etVal: EditText
    lateinit var btnMiKm: Button
    lateinit var btnKmMi: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etVal = findViewById(R.id.et_val)
        btnMiKm = findViewById(R.id.btn_mi_to_km)
        btnKmMi = findViewById(R.id.btn_km_to_mi)
        tvResult = findViewById(R.id.tv_result)

        btnMiKm.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = value * 1.60934
            tvResult.text = "$value miles is $result km"
        }

        btnKmMi.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = value / 1.60934
            tvResult.text = "$value km is $result miles"
        }
    }
}