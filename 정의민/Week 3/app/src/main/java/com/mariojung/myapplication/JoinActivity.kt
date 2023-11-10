package com.mariojung.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mariojung.myapplication.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button3.setOnClickListener {
            val resultIntent = Intent()
            val inputId = binding.editId.text.toString()
            val inputPwd = binding.editPwd.text.toString()
            val inputNick = binding.editNick.text.toString()
            val inputMbti = binding.editMbti.text.toString()
            val inputIntro = binding.editIntro.text.toString()


            if (inputId.length >= 6 && inputId.length <= 8) {
                if (inputPwd.length >= 8 && inputPwd.length <= 12) {
                    if(inputNick !=" "){
                        if(inputMbti.length == 4){
                            if(inputIntro != " "){
                                resultIntent.putExtra("id", inputId)
                                resultIntent.putExtra("pwd", inputPwd)
                                resultIntent.putExtra("Nick", inputNick)
                                resultIntent.putExtra("Mbti", inputMbti)
                                resultIntent.putExtra("Intro", inputIntro)

                                setResult(RESULT_OK, resultIntent)
                                finish()
                            }
                        }
                    }
                }
            }
        }
    }


}