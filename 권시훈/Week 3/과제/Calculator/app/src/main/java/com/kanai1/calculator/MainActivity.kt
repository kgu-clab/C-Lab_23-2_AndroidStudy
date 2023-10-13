package com.kanai1.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kanai1.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener{
            if(binding.input1.text.toString() == "" || binding.input2.text.toString() == "") {
                Toast.makeText(
                    this,
                    "숫자가 비어있습니다",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                var num1 = Integer.parseInt(binding.input1.text.toString())
                var num2 = Integer.parseInt(binding.input2.text.toString())

                binding.result.text = "Result: ${num1 + num2}"
            }
        }

        binding.buttonMinus.setOnClickListener{
            if(binding.input1.text.toString() == "" || binding.input2.text.toString() == "") {
                Toast.makeText(
                    this,
                    "숫자가 비어있습니다",
                    Toast.LENGTH_SHORT
                ).show()
                binding.result.text = "Result: -"
            } else {
                var num1 = Integer.parseInt(binding.input1.text.toString())
                var num2 = Integer.parseInt(binding.input2.text.toString())

                binding.result.text = "Result: ${num1 - num2}"
            }
        }

        binding.buttonMultiply.setOnClickListener{
            if(binding.input1.text.toString() == "" || binding.input2.text.toString() == "") {
                Toast.makeText(
                    this,
                    "숫자가 비어있습니다",
                    Toast.LENGTH_SHORT
                ).show()
                binding.result.text = "Result: -"
            } else {
                var num1 = Integer.parseInt(binding.input1.text.toString())
                var num2 = Integer.parseInt(binding.input2.text.toString())

                binding.result.text = "Result: ${num1 * num2}"
            }
        }

        binding.buttonDiv.setOnClickListener{
            if(binding.input1.text.toString() == "" || binding.input2.text.toString() == "") {
                Toast.makeText(
                    this,
                    "숫자가 비어있습니다",
                    Toast.LENGTH_SHORT
                ).show()
                binding.result.text = "Result: -"
            } else {
                var num1 = Integer.parseInt(binding.input1.text.toString())
                var num2 = Integer.parseInt(binding.input2.text.toString())

                if(num2 == 0) {
                    Toast.makeText(
                        this,
                        "Cannot Div in 0",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.result.text = "Result: -"
                } else {
                    binding.result.text = "Result: ${num1 / num2}"
                }
            }
        }
    }
}