package com.jiyoxn.calhw

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.num1)
        input2 = findViewById(R.id.num2)
        resultText = findViewById(R.id.result)

        input1.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        input2.inputType = android.text.InputType.TYPE_CLASS_NUMBER

        val addB = findViewById<Button>(R.id.add)
        val subB = findViewById<Button>(R.id.sub)
        val mulB = findViewById<Button>(R.id.mul)
        val divB = findViewById<Button>(R.id.div)

        addB.setOnClickListener { performOperation("add") }
        subB.setOnClickListener { performOperation("sub") }
        mulB.setOnClickListener { performOperation("mul") }
        divB.setOnClickListener { performOperation("div") }
    }

    private fun performOperation(operation: String) {
        val num1Str = input1.text.toString()
        val num2Str = input2.text.toString()

            val num1 = num1Str.toInt()
            val num2 = num2Str.toInt()
            var result = 0

            when (operation) {
                "add" -> result = num1 + num2
                "sub" -> result = num1 - num2
                "mul" -> result = num1 * num2
                "div" -> {
                    if (num2 != 0) {
                        result = num1 / num2
                    } else {
                        showToast("0으로 나눌 수 없습니다")
                        resultText.text="result: - "
                        return
                    }
                }
            }

            resultText.text = "result: $result"

    }

    private fun showToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT).show()
    }
}
