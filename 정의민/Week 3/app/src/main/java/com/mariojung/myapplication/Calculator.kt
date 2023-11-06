package com.mariojung.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mariojung.myapplication.databinding.CalculatorBinding

class Calculator : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) { //어노테이션 수정(삭제함)
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPlus.setOnClickListener{
            val et_main_plus = binding.editTextTextFirst.text.toString()
            val et_main_plus_sec = binding.editTextTextSec.text.toString()

            val int_et_main_plus : Int = et_main_plus.toInt() // 첫번째 번호
            val int_et_main_plus_sec : Int = et_main_plus_sec.toInt() // 두번째 번호

            val result : Int = int_et_main_plus + int_et_main_plus_sec // 더하기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonMinus.setOnClickListener{
            val et_main_minus = binding.editTextTextFirst.text.toString()
            val et_main_minus_sec = binding.editTextTextSec.text.toString()

            val int_et_main_minus  : Int = et_main_minus.toInt() // 첫번째 번호
            val int_et_main_minus_sec : Int = et_main_minus_sec.toInt() // 두번째 번호

            val result : Int = int_et_main_minus  - int_et_main_minus_sec // 빼기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonMulty.setOnClickListener{
            val et_main_multy = binding.editTextTextFirst.text.toString()
            val et_main_multy_sec = binding.editTextTextSec.text.toString()

            val int_et_main_multy : Int = et_main_multy.toInt() // 첫번째 번호
            val int_et_main_multy_sec : Int = et_main_multy_sec.toInt() // 두번째 번호

            val result : Int = int_et_main_multy * int_et_main_multy_sec // 곱하기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonDiv.setOnClickListener{
            val et_main_div = binding.editTextTextFirst.text.toString()
            val et_main_div_sec = binding.editTextTextSec.text.toString()

            val int_et_main_div : Int = et_main_div.toInt() // 첫번째 번호
            val int_et_main_div_sec : Int = et_main_div_sec.toInt() // 두번째 번호
            val notion = "arguments are can not divided by 0"
            if(int_et_main_div_sec == 0){
                Toast.makeText(
                    this,
                    notion,
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                val result : Int = int_et_main_div / int_et_main_div_sec // 나누기 결과값

                val textView = binding.resultPoint
                textView.text = result.toString()
            }
        }
    }
}
