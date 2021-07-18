package io.budge.calculator.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.budge.calculator.R
import io.budge.calculator.di.providers.CalculatorComponentProvider
import io.budge.calculator.usecase.SumUseCase
import io.budge.calculator.usecase.SumUseCase.Result.Failure
import io.budge.calculator.usecase.SumUseCase.Result.Success
import javax.inject.Inject

class CalculatorActivity : AppCompatActivity() {

    @Inject
    lateinit var sumUseCase: SumUseCase

    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        (application as CalculatorComponentProvider)
            .getCalculatorComponent()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun calculateSum() {
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()

        sumUseCase.execute(firstNumber, secondNumber).let {
            when (it) {
                is Success -> resultTextView.text = it.result.toString()
                is Failure -> showFailureMessage(it.message)
            }
        }
    }

    private fun showFailureMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum()
        }
    }
}