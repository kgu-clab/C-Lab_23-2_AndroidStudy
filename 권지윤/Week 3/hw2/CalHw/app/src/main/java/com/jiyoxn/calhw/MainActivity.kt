package com.jiyoxn.calhw

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jiyoxn.calhw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.num1.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        binding.num2.inputType = android.text.InputType.TYPE_CLASS_NUMBER

        binding.add.setOnClickListener { performOperation("add") }
        binding.sub.setOnClickListener { performOperation("sub") }
        binding.mul.setOnClickListener { performOperation("mul") }
        binding.div.setOnClickListener { performOperation("div") }
    }

    private fun performOperation(operation: String) {
        val input1 = binding.num1.text.toString()
        val input2 = binding.num2.text.toString()

        val num1 = input1.toInt()
        val num2 = input2.toInt()
        var result = 0

        when (operation) {
            "add" -> result = num1 + num2
            "sub" -> result = num1 - num2
            "mul" -> result = num1 * num2
            "div" -> {
                if (num2 == 0) {
                    showToast("0으로 나눌 수 없습니다")
                    binding.result.text = "result: - "
                    return
                }
                result = num1 / num2
            }
        }
        binding.result.text = "result: $result"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
