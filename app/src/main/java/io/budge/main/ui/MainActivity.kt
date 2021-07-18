package io.budge.main.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.budge.calculator.ui.CalculatorActivity
import io.budge.core.modes.AppSubscription
import io.budge.main.R
import io.budge.main.di.ApplicationComponentProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSubscription: AppSubscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationComponentProvider)
            .getApplicationComponent()
            .inject(this)

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