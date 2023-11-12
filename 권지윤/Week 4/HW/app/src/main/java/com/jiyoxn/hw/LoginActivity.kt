package com.jiyoxn.hw

import android.content.Intent
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jiyoxn.hw.databinding.ActivityLoginBinding
import com.jiyoxn.hw.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val receivedId = intent.getStringExtra("id")
        val receivedPw = intent.getStringExtra("pw")
        val receivedName = intent.getStringExtra("name")
        val receivedMbti = intent.getStringExtra("mbti")
        val receivedIntroduce = intent.getStringExtra("introduce")

        binding.editId.setText(receivedId)
        binding.editTextPassword.setText(receivedPw)

        binding.loginbtn.setOnClickListener {
            val id = binding.editId.text.toString()
            val pw = binding.editTextPassword.text.toString()
            if (id == receivedId && pw == receivedPw) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id",receivedId)
                intent.putExtra("pw",receivedPw)
                intent.putExtra("name",receivedName)
                intent.putExtra("mbti",receivedMbti)
                intent.putExtra("introduce",receivedIntroduce)
                startActivity(intent)
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        }
    }
