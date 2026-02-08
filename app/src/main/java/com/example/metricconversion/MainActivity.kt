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
    lateinit var btnFC: Button
    lateinit var btnCF: Button
    lateinit var btnFK: Button
    lateinit var btnCK: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etVal = findViewById(R.id.et_val)
        btnMiKm = findViewById(R.id.btn_mi_to_km)
        btnKmMi = findViewById(R.id.btn_km_to_mi)
        btnFC = findViewById(R.id.btn_f_to_c)
        btnCF = findViewById(R.id.btn_c_to_f)
        btnFK = findViewById(R.id.btn_f_to_k)
        btnCK = findViewById(R.id.btn_c_to_k)

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

        btnFC.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = (value-32)*(0.55556)
            val formattedresult = String.format("%.2f", result)
            tvResult.text = "$value degrees Fahrenheit is $formattedresult degrees Celsius"
        }

        btnCF.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = ((value*1.8) + 32)
            val formattedresult = String.format("%.2f", result)
            tvResult.text = "$value degrees Celsius is $formattedresult degrees Fahrenheit"
        }

        btnFK.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = ((value-32)*(0.55556)) + 273.15
            val formattedresult = String.format("%.2f", result)
            tvResult.text = "$value degrees Fahrenheit is $formattedresult degrees Kelvin"
        }

        btnCK.setOnClickListener {
            val value = etVal.text.toString().toDouble()
            val result = value + 273.15
            val formattedresult = String.format("%.2f", result)
            tvResult.text = "$value degrees Celsius is $formattedresult degrees Kelvin"
        }
    }
}