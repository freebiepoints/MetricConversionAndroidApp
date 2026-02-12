package com.example.metricconversion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.view.View


/**
 * The main activity for the metric conversion application.
 * This activity allows users to convert values between different units.
 */
class MainActivity : AppCompatActivity() {
    // UI elements
    lateinit var etVal: EditText
    lateinit var btnMiKm: Button
    lateinit var btnKmMi: Button
    lateinit var btnFC: Button
    lateinit var btnCF: Button
    lateinit var btnFK: Button
    lateinit var btnCK: Button
    lateinit var tvResult: TextView

    /**
     * Called when the activity is first created.
     * This is where you should do all of your normal static set up:
     * create views, bind data to lists, etc.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        etVal = findViewById(R.id.et_val)
        btnMiKm = findViewById(R.id.btn_mi_to_km)
        btnKmMi = findViewById(R.id.btn_km_to_mi)
        btnFC = findViewById(R.id.btn_f_to_c)
        btnCF = findViewById(R.id.btn_c_to_f)
        btnFK = findViewById(R.id.btn_f_to_k)
        btnCK = findViewById(R.id.btn_c_to_k)
        tvResult = findViewById(R.id.tv_result)

        // Spinner elements
        var selectedDecimals = 2 // default
        val roundingOptions = listOf("0 decimals", "1 decimal", "2 decimals", "3 decimals", "4 decimals")
        val spinner = findViewById<Spinner>(R.id.roundingSpinner)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            roundingOptions
        )
        spinner.adapter = adapter
        spinner.setSelection(2) // default to 2 decimals
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedDecimals = position
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


        // Set click listener for miles to kilometers conversion
        btnMiKm.setOnClickListener {
            getInputValue()?.let { value ->
                val result = value * 1.60934
                tvResult.text = "$value miles is ${result.formatDecimals(selectedDecimals)} km"
            }
        }

        // Set click listener for kilometers to miles conversion
        btnKmMi.setOnClickListener {
            getInputValue()?.let { value ->
                val result = value / 1.60934
                tvResult.text = "$value km is ${result.formatDecimals(selectedDecimals)} miles"
            }
        }

        // Set click listener for Fahrenheit to Celsius conversion
        btnFC.setOnClickListener {
            getInputValue()?.let { value ->
                val result = (value - 32) * (0.55556)
                tvResult.text = "$value degrees Fahrenheit is ${result.formatDecimals(selectedDecimals)} degrees Celsius"
            }
        }

        // Set click listener for Celsius to Fahrenheit conversion
        btnCF.setOnClickListener {
            getInputValue()?.let { value ->
                val result = ((value * 1.8) + 32)
                tvResult.text = "$value degrees Celsius is ${result.formatDecimals(selectedDecimals)} degrees Fahrenheit"
            }
        }

        // Set click listener for Fahrenheit to Kelvin conversion
        btnFK.setOnClickListener {
            getInputValue()?.let { value ->
                val result = ((value - 32) * (0.55556)) + 273.15
                tvResult.text = "$value degrees Fahrenheit is ${result.formatDecimals(selectedDecimals)} degrees Kelvin"
            }
        }

        // Set click listener for Celsius to Kelvin conversion
        btnCK.setOnClickListener {
            getInputValue()?.let { value ->
                val result = value + 273.15
                tvResult.text = "$value degrees Celsius is ${result.formatDecimals(selectedDecimals)} degrees Kelvin"
            }
        }
    }

    /**
     * Gets the input value from the EditText.
     * @return The a double representing the value, or null if the input is invalid.
     */
    private fun getInputValue(): Double? {
        val value = etVal.text.toString().toDoubleOrNull()
        if (value == null) {
            etVal.error = "Please enter a valid number"
        }
        return value
    }

    private fun Double.formatDecimals(decimals: Int): String {
        return String.format("%.${decimals}f", this)
    }
}
