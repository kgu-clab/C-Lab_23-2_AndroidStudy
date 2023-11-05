package com.tnals.week4_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tnals.week4_hw.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userDataList = mutableListOf<User>()
        inputData(userDataList)
        goLogin(userDataList)
        goSignUp()

    }

    private fun goSignUp() {
        binding.tvMainSignUp.setOnClickListener {
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signUpIntent)
        }
    }

    private fun inputData(userDataList: MutableList<User>) {
        val data = intent.getParcelableExtra<User>("user_data")
        if (data != null){
            userDataList.add(data)
            binding.inputID.setText(data.id)
            binding.inputPassword.setText(data.pw)
        }
    }

    private fun goLogin(userDataList: MutableList<User>) {
        binding.tvMainLogin.setOnClickListener {
            val id = binding.inputID.text.toString()
            val pw = binding.inputPassword.text.toString()
            var exist=false
            userDataList.forEach {
                if (it.id == id && it.pw == pw) {
                    val loginIntent=Intent(this,MainActivity::class.java)
                    loginIntent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
                    loginIntent.putExtra("user_data",it)
                    val text = "Login Success"
                    Toast.makeText(
                        this,
                        text,
                        Toast.LENGTH_SHORT
                    ).show()
                    exist=true
                    startActivity(loginIntent)
                }
            }
            if(!exist){
                val text="User information does not exist."
                Toast.makeText(
                    this,
                    text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}