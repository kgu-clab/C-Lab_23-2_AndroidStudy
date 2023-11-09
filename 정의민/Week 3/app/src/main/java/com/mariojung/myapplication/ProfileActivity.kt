package com.mariojung.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mariojung.myapplication.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity(){
    private lateinit var binding: ActivityProfileBinding
    private var receivedId: String? = null
    private var receivedPwd: String? = null
    private var receivedNick: String? = null
    private var receivedMbti: String? = null
    private var receivedIntro: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)

        receivedId = intent.getStringExtra("sendId")
        receivedPwd = intent.getStringExtra("sendPwd")
        receivedNick = intent.getStringExtra("sendNick")
        receivedMbti = intent.getStringExtra("sendMbti")
        receivedIntro = intent.getStringExtra("sendIntro")

        binding.textId.setText(receivedId)
        binding.textPwd.setText(receivedPwd)
        binding.textNick.setText(receivedNick)
        binding.textMbti.setText(receivedMbti)
        binding.textIntro.setText(receivedIntro)
    }
}