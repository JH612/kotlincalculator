package com.example.uj_pp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val buttons = arrayOf(
            R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour,
            R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine,
            R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        )

        for (buttonId in buttons) {
            val button: Button = findViewById(buttonId)
            button.setOnClickListener { onButtonClick(button) }
        }

        val btnClear: Button = findViewById(R.id.btnClear)
        btnClear.setOnClickListener { clearResult() }

        val btnEquals: Button = findViewById(R.id.btnEquals)
        btnEquals.setOnClickListener { calculateResult() }
    }

    private fun onButtonClick(button: Button) {
        val currentExpression = tvResult.text.toString()
        val buttonText = button.text.toString()

        tvResult.text = "$currentExpression$buttonText"
    }

    private fun clearResult() {
        tvResult.text = ""
    }

    private fun calculateResult() {
        try {

        val expression = ExpressionBuilder(tvResult.text.toString()).build()
        val result = expression.evaluate()
        tvResult.text = result.toString()
        } catch (e: Exception) {
            tvResult.text = "Error"
    }
    }
}
