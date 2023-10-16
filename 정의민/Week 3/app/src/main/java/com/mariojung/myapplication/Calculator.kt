package com.mariojung.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mariojung.myapplication.databinding.CalculatorBinding

class Calculator : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPlus.setOnClickListener{
            val Fnum = binding.editTextTextFirst.text.toString()
            val Bnum = binding.editTextTextSec.text.toString()

            val intFnum : Int = Fnum.toInt() // 첫번째 번호
            val intBnum : Int = Bnum.toInt() // 두번째 번호

            val result : Int = intFnum + intBnum // 더하기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonMinus.setOnClickListener{
            val Fnum = binding.editTextTextFirst.text.toString()
            val Bnum = binding.editTextTextSec.text.toString()

            val intFnum : Int = Fnum.toInt() // 첫번째 번호
            val intBnum : Int = Bnum.toInt() // 두번째 번호

            val result : Int = intFnum - intBnum // 빼기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonMulty.setOnClickListener{
            val Fnum = binding.editTextTextFirst.text.toString()
            val Bnum = binding.editTextTextSec.text.toString()

            val intFnum : Int = Fnum.toInt() // 첫번째 번호
            val intBnum : Int = Bnum.toInt() // 두번째 번호

            val result : Int = intFnum * intBnum // 곱하기 결과값

            val textView = binding.resultPoint
            textView.text = result.toString()
        }

        binding.buttonDiv.setOnClickListener{
            val Fnum = binding.editTextTextFirst.text.toString()
            val Bnum = binding.editTextTextSec.text.toString()

            val intFnum : Int = Fnum.toInt() // 첫번째 번호
            val intBnum : Int = Bnum.toInt() // 두번째 번호
            val notion = "arguments are can not divided by 0"
            if(intBnum == 0){
                Toast.makeText(
                    this,
                    notion,
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                val result : Int = intFnum / intBnum // 나누기 결과값

                val textView = binding.resultPoint
                textView.text = result.toString()
            }
        }
    }
}