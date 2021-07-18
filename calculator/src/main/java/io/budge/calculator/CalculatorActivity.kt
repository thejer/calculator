package io.budge.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import javax.inject.Inject

class CalculatorActivity : AppCompatActivity() {

//    @Inject
    lateinit var sumUseCase: SumUseCase

    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerCalculatorComponent.builder().build().inject(this)
        setContentView(R.layout.activity_calculator)

        bindViews()
        bindListeners()
    }

    private fun calculateSum() {
        val firstNumber = firstNumberEditText.text.toString().toInt()
        val secondNumber = secondNumberEditText.text.toString().toInt()
        val result = sumUseCase.execute(firstNumber, secondNumber)
        resultTextView.text = result.toString()
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