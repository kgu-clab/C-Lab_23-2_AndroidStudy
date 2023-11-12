package com.jiyoxn.hw

import android.content.Intent
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jiyoxn.hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedId = intent.getStringExtra("id")
        val receivedPw = intent.getStringExtra("pw")
        val receivedName = intent.getStringExtra("name")
        val receivedMbti = intent.getStringExtra("mbti")
        val receivedIntroduce = intent.getStringExtra("introduce")

        binding.textView.setText(receivedId)
        binding.textView2.setText(receivedPw)
        binding.textView3.setText(receivedName)
        binding.textView4.setText(receivedMbti)
        binding.textView5.setText(receivedIntroduce)



    }
}