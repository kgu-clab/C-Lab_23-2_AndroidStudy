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

        binding.activityMainBtnAdd.setOnClickListener(View.OnClickListener {
            val num1 = binding.activityMainEtNum1.text.toString()
            val num2 = binding.activityMainEtNum2.text.toString()
            if (!num1.isNullOrBlank() && !num2.isNullOrBlank()) {
                val result = (num1.toInt() + num2.toInt()).toString()
                binding.activityMainTvResult.text = result
            }
        })

        binding.activityMainBtnMin.setOnClickListener(View.OnClickListener {
            val num1 = binding.activityMainEtNum1.text.toString()
            val num2 = binding.activityMainEtNum2.text.toString()
            if (!num1.isNullOrBlank() && !num2.isNullOrBlank()) {
                val result = (num1.toInt() - num2.toInt()).toString()
                binding.activityMainTvResult.text = result
            }
        })

        binding.activityMainBtnMul.setOnClickListener(View.OnClickListener {
            val num1 = binding.activityMainEtNum1.text.toString()
            val num2 = binding.activityMainEtNum2.text.toString()
            if (!num1.isNullOrBlank() && !num2.isNullOrBlank()) {
                val result = (num1.toInt() * num2.toInt()).toString()
                binding.activityMainTvResult.text = result
            }
        })

        binding.activityMainBtnDiv.setOnClickListener(View.OnClickListener {
            val num1 = binding.activityMainEtNum1.text.toString()
            val num2 = binding.activityMainEtNum2.text.toString()
            if (!num1.isNullOrBlank() && !num2.isNullOrBlank()) {
                if (num2.toInt() == 0) {
                    binding.activityMainTvResult.text = "-"
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    val result = (num1.toInt() / num2.toInt()).toString()
                    binding.activityMainTvResult.text = result
                }
            }
        })
    }
}
