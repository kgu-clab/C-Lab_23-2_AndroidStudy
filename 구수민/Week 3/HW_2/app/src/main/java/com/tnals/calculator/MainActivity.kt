package com.tnals.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tnals.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun sumNum(operator: String): String {
            val num1: Int
            val num2: Int

            try {
                num1 = binding.inputNum1.text.toString().toInt()
                num2 = binding.inputNum2.text.toString().toInt()
            } catch (ex: NumberFormatException) {
                return "Error"
            }

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



        binding.plusButton.setOnClickListener {
            val sum = sumNum("+")
            binding.result.text = getString(R.string.result, sum)
        }

        binding.minusButton.setOnClickListener {
            val sum = sumNum("-")
            binding.result.text = getString(R.string.result, sum)
        }

        binding.multiplyButton.setOnClickListener {
            val sum = sumNum("*")
            binding.result.text = getString(R.string.result, sum)
        }

        binding.divideButton.setOnClickListener {
            val sum = sumNum("/")
            binding.result.text = getString(R.string.result, sum)
            if (sum == "-") {
                val errormessage = "0으로 나눌 수 없습니다."
                Toast.makeText(
                    this,
                    errormessage,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}