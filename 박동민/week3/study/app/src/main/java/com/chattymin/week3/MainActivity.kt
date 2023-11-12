package com.chattymin.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chattymin.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, TestActivity::class.java)

        binding.button.setOnClickListener {
            val text = binding.editID.text.toString()
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()

            startActivity(intent)
        }
    }
}
























//
//class SignUpActivity: AppCompatActivity() {
//    private lateinit var binding: ActivitySignUpBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySignUpBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//}