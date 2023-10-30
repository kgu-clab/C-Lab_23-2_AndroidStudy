package com.mingmingmon.week3_hw_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.mingmingmon.week3_hw_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun getNum1(): Int? {
            val num1Text: String = binding.activiyMainEtFirstNumber.text.toString()
            val num1: Int? = num1Text.toIntOrNull()

            return num1
        }

        fun getNum2(): Int? {
            val num2Text: String = binding.activiyMainEtSecondNumber.text.toString()
            val num2: Int? = num2Text.toIntOrNull()

            return num2
        }

        fun warningToast(inputText: String) {
            //String으로 상황에 맞는 경고 메세지를 받아서 띄우도록 수정했습니다.
            binding.activityMainEtResult.text = "Result : -"
            val text = inputText
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }

        fun calculate(op: String): String {
            val num1: Int? = getNum1()
            val num2: Int? = getNum2()
            val result: Int?
            if (num1 != null && num2 != null) {
                when (op) {
                    "+" -> {
                        result = num1 + num2
                        binding.activityMainEtResult.text = "Result : $result"
                    }
                    "-" -> {
                        result = num1 - num2
                        binding.activityMainEtResult.text = "Result : $result"
                    }
                    "*" -> {
                        result = num1 * num2
                        binding.activityMainEtResult.text = "Result : $result"
                    }
                    "/" -> {
                        if (num2 == 0) {
                            warningToast("0으로 나눌 수 없습니다.")
                        } else {
                            result = num1 / num2
                            binding.activityMainEtResult.text = "Result : $result"
                        }
                    }
                }
            }
            else{
                warningToast("값을 입력해주세요")
            }
            return "error"
        }

        binding.activityMainBunPlus.setOnClickListener {
            calculate("+")
        }

        binding.activityMainBunMinus.setOnClickListener {
            calculate("-")
        }

        binding.activityMainBunMul.setOnClickListener {
            calculate("*")
        }

        binding.activityMainBunDiv.setOnClickListener {
            calculate("/")
        }
    }
}
