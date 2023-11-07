package com.tnals.week4_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tnals.week4_hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()
    }

    private fun showData(){
        val data = intent.getParcelableExtra<User>("user_data")
        if (data != null) {
            binding.idText.text=getString(R.string.id_is, data.id)
            binding.passwordText.text=getString(R.string.pw_is, data.pw)
            binding.nicknameText.text=getString(R.string.name_is, data.nickname)
            binding.mbtiText.text=getString(R.string.mbti_is, data.mbti)
            binding.aboutmeText.text=getString(R.string.about_is, data.aboutme)
        }

    }
}