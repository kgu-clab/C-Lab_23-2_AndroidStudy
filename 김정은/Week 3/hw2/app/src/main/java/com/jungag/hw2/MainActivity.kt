package com.jungag.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.jungag.hw2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(View.OnClickListener {
            val num1 = binding.num1.text.toString()
            val num2 = binding.num2.text.toString()
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val result = (num1.toInt() + num2.toInt()).toString()
                binding.result.text = result
            }
        })

        binding.button2.setOnClickListener(View.OnClickListener {
            val num1 = binding.num1.text.toString()
            val num2 = binding.num2.text.toString()
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val result = (num1.toInt() - num2.toInt()).toString()
                binding.result.text = result
            }
        })

        binding.button3.setOnClickListener(View.OnClickListener {
            val num1 = binding.num1.text.toString()
            val num2 = binding.num2.text.toString()
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val result = (num1.toInt() * num2.toInt()).toString()
                binding.result.text = result
            }
        })

        binding.button4.setOnClickListener(View.OnClickListener {
            val num1 = binding.num1.text.toString()
            val num2 = binding.num2.text.toString()
            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                if (num2.toInt() == 0) {
                    binding.result.text = "-"
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    val result = (num1.toInt() / num2.toInt()).toString()
                    binding.result.text = result
                }
            }
        })
    }
}
