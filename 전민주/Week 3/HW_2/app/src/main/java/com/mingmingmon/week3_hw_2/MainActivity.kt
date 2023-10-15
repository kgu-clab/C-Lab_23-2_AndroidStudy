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

        fun getNum1() : Int?{
            val num1Text: String = binding.editFirstNumber.text.toString()
            val num1: Int? = num1Text.toIntOrNull()

            return num1
        }

        fun getNum2() : Int?{
            val num2Text: String = binding.editSecondNumber.text.toString()
            val num2: Int? = num2Text.toIntOrNull()

            return num2
        }

        fun toastToPutNumbers(){ //값을 입력하지 않았을 때 toast로 값 입력해달라고 띄워주는 기능 만들고 싶어서 넣어봤습니다.
            val text = "값을 입력해주세요"
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }

        fun toastToWarnDivideZero(){
            val text = "0으로 나눌 수 없습니다."
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.plusButton.setOnClickListener {
            val num1: Int? = getNum1()
            val num2: Int? = getNum2()

            if (num1 != null && num2 != null) {
                val result: Int = num1 + num2
                binding.resultText.text = "Result : $result"
            }
            else{
                binding.resultText.text = "Result : -"
                toastToPutNumbers()
            }
        }

        binding.minusButton.setOnClickListener {
            val num1: Int? = getNum1()
            val num2: Int? = getNum2()

            if (num1 != null && num2 != null) {
                val result: Int = num1 - num2
                binding.resultText.text = "Result : $result"
            }
            else{
                binding.resultText.text = "Result : -"
                toastToPutNumbers()
            }
        }

        binding.multiplyButton.setOnClickListener {
            val num1: Int? = getNum1()
            val num2: Int? = getNum2()

            if (num1 != null && num2 != null) {
                val result: Int = num1 * num2
                binding.resultText.text = "Result : $result"
            }
            else{
                binding.resultText.text = "Result : -"
                toastToPutNumbers()
            }
        }

        binding.divideButton.setOnClickListener {
            val num1: Int? = getNum1()
            val num2: Int? = getNum2()

            if(num2 == 0){
                binding.resultText.text = "Result : -"
                toastToWarnDivideZero()
            }

            else if (num1 != null && num2 != null) {
                val result: Int = num1 / num2
                binding.resultText.text = "Result : $result"
            }
            else{
                binding.resultText.text = "Result : -"
                toastToPutNumbers()
            }
        }

    }
}
