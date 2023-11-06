package com.kanai1.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kanai1.signup.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMypageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userinfo = intent.getSerializableExtra("userInfo", userInfoClass::class.java)
        if(userinfo != null) {
            binding.activityMypageTvID.setText("id: ${userinfo.id}")
            binding.activityMypageTvNickname.setText("nickname: ${userinfo.nickname}")
            binding.activityMypageTvMBTI.setText("MBTI: ${userinfo.MBTI}")
            binding.activityMypageTvAboutMe.setText("AboutMe: ${userinfo.AboutMe}")
        }

    }
}