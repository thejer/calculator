package io.budge.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.budge.calculator.CalculatorActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindListeners()
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.calculator_button).setOnClickListener {
            startCalculatorActivity()
        }
    }

    private fun startCalculatorActivity() {
        startActivity(
            Intent(this, CalculatorActivity::class.java)
        )
    }
}