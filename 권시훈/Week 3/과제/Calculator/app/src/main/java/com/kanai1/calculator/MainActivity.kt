package com.kanai1.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kanai1.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    fun errorToastShowandEditResult(binding: ActivityMainBinding, msg: String){
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
        binding.activityMainTvResult.text = "Result: -"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMainBtnAdd.setOnClickListener{
            if(binding.activityMainEtNum1.text.toString().isEmpty() || binding.activityMainEtNum2.text.toString().isEmpty()) {
                errorToastShowandEditResult(binding, "숫자가 비어있습니다.")
            } else {
                var num1 = Integer.parseInt(binding.activityMainEtNum1.text.toString())
                var num2 = Integer.parseInt(binding.activityMainEtNum2.text.toString())

                binding.activityMainTvResult.text = "Result: ${num1 + num2}"
            }
        }

        binding.activityMainBtnMinus.setOnClickListener{
            if(binding.activityMainEtNum1.text.toString().isEmpty() || binding.activityMainEtNum2.text.toString().isEmpty()) {
                errorToastShowandEditResult(binding, "숫자가 비어있습니다.")
            } else {
                var num1 = Integer.parseInt(binding.activityMainEtNum1.text.toString())
                var num2 = Integer.parseInt(binding.activityMainEtNum2.text.toString())

                binding.activityMainTvResult.text = "Result: ${num1 - num2}"
            }
        }

        binding.activityMainBtnMultiply.setOnClickListener{
            if(binding.activityMainEtNum1.text.toString().isEmpty() || binding.activityMainEtNum2.text.toString().isEmpty()) {
                errorToastShowandEditResult(binding, "숫자가 비어있습니다.")
            } else {
                var num1 = Integer.parseInt(binding.activityMainEtNum1.text.toString())
                var num2 = Integer.parseInt(binding.activityMainEtNum2.text.toString())

                binding.activityMainTvResult.text = "Result: ${num1 * num2}"
            }
        }

        binding.activityMainBtnDiv.setOnClickListener{
            if(binding.activityMainEtNum1.text.toString() == "" || binding.activityMainEtNum2.text.toString() == "") {
                errorToastShowandEditResult(binding, "숫자가 비어있습니다.")
            } else {
                var num1 = Integer.parseInt(binding.activityMainEtNum1.text.toString())
                var num2 = Integer.parseInt(binding.activityMainEtNum2.text.toString())

                if(num2 == 0) {
                    errorToastShowandEditResult(binding, "Cannot Div in 0.")
                } else {
                    binding.activityMainTvResult.text = "Result: ${num1 / num2}"
                }
            }
        }
    }
}