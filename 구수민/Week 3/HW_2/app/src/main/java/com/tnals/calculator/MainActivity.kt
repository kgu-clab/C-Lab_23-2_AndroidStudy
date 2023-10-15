package com.tnals.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numInput1 = findViewById<EditText>(R.id.inputNum1)
        val numInput2 = findViewById<EditText>(R.id.inputNum2)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val result = findViewById<TextView>(R.id.result)

        fun sumNum(operator: String): String {
            val num1 = numInput1.text.toString().toInt()
            val num2 = numInput2.text.toString().toInt()
            when (operator) {
                "+" -> return (num1 + num2).toString()
                "-" -> return (num1 - num2).toString()
                "*" -> return (num1 * num2).toString()
                "/" -> {
                    if (num2 == 0)
                        return "-"
                    return (num1 / num2).toString()
                }
            }
            return "Error"
        }


        plusButton.setOnClickListener {
            val sum = sumNum("+")
            result.text = "Result : $sum"
        }

        minusButton.setOnClickListener {
            val sum = sumNum("-")
            result.text = "Result : $sum"
        }

        multiplyButton.setOnClickListener {
            val sum = sumNum("*")
            result.text = "Result : $sum"
        }

        divideButton.setOnClickListener {
            val sum = sumNum("/")
            result.text = "Result : $sum"
            if(sum == "-"){
                val errormessage ="0으로 나눌 수 없습니다."
                Toast.makeText(
                    this,
                    errormessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}