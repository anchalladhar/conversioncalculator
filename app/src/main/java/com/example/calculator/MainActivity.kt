package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView
    private lateinit var conversionSpinner: Spinner
    private lateinit var convertButton: Button

    private val conversionOptions = arrayOf(
        "in to cm",
        "cm to in",
        "m to km",
        "km to m",
        "L to ml",
        "ml to L",
        "kg to g",
        "g to kg",
        "lb to kg",
        "kg to lb"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.input_edit_text)
        outputTextView = findViewById(R.id.output_text_view)
        conversionSpinner = findViewById(R.id.conversion_spinner)
        convertButton = findViewById(R.id.convert_button)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionSpinner.adapter = adapter

        conversionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Clear input and output fields when the conversion type is changed
                inputEditText.text.clear()
                outputTextView.text = ""
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        convertButton.setOnClickListener {
            convert()
        }
    }

    private fun convert() {
        val inputText = inputEditText.text.toString().trim()
        if (inputText.isNotEmpty()) {
            val inputValue = inputText.toDouble()

            val conversionType = conversionSpinner.selectedItem.toString()
            val result: Double

            when (conversionType) {
                "in to cm" -> {
                    result = inputValue * 2.54
                    outputTextView.text = result.toString()
                }
                "cm to in" -> {
                    result = inputValue / 2.54
                    outputTextView.text = result.toString()
                }
                "m to km" -> {
                    result = inputValue / 1000
                    outputTextView.text = result.toString()
                }
                "km to m" -> {
                    result = inputValue * 1000
                    outputTextView.text = result.toString()
                }
                "L to ml" -> {
                    result = inputValue * 1000
                    outputTextView.text = result.toString()
                }
                "ml to L" -> {
                    result = inputValue / 1000
                    outputTextView.text = result.toString()
                }
                "kg to g" -> {
                    result = inputValue * 1000
                    outputTextView.text = result.toString()
                }
                "g to kg" -> {
                    result = inputValue / 1000
                    outputTextView.text = result.toString()
                }
                "lb to kg" -> {
                    result = inputValue * 0.453592
                    outputTextView.text = result.toString()
                }
                "kg to lb" -> {
                    result = inputValue * 2.20462
                    outputTextView.text = result.toString()
                }
            }
        }
    }
}
