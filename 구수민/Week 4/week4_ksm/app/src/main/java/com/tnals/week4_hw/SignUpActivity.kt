package com.tnals.week4_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tnals.week4_hw.databinding.ActivitySignupBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signupButton()

    }

    private fun addData(): User {
        return User(
            id = binding.editID.text.toString(),
            pw = binding.editPassword.text.toString(),
            nickname = binding.editNickname.text.toString(),
            mbti = binding.editMBTI.text.toString(),
            aboutme = binding.editAboutMe.text.toString()
        )
    }

    private fun showToast(data: String, user: User) {
        var errorText =" "
        if (data == "ID")
            errorText = getString(R.string.error_id, user.id.length)
        if (data == "PW")
            errorText = getString(R.string.error_pw, user.pw.length)
        if (data == "NICKNAME")
            errorText = getString(R.string.error_name)
        if (data == "MBTI")
            errorText = getString(R.string.error_mbti)
        if (data == "ABOUTME")
            errorText = getString(R.string.error_about)
        Toast.makeText(
            this,
            errorText,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun suitability(
        user: User
    ): Boolean {
        var suitnum = 0

        if (user.aboutme.isEmpty())
            suitnum = 5
        if (user.aboutme.isNotEmpty()) {
            for (element in user.aboutme) {
                if (element == ' ') {
                    suitnum = 5
                }
            }
        }

        if (user.mbti.length != 4)
            suitnum = 4
        else {
            if(!((user.mbti[0]=='E'||user.mbti[0]=='I')&&(user.mbti[1]=='S'||user.mbti[1]=='N'
                        )&&(user.mbti[2]=='T'||user.mbti[2]=='F')&&(user.mbti[3]=='J'||user.mbti[3]=='P')))
                suitnum=4
        }

        if (user.nickname.isEmpty())
            suitnum = 3
        if (user.nickname.isNotEmpty()) {
            for (element in user.nickname) {
                if (element == ' ') {
                    suitnum = 3
                }
            }
        }

        if (user.pw.length < 8 || user.pw.length > 12) {
            suitnum = 2
        }

        if (user.id.length < 6 || user.id.length > 10) {
            suitnum = 1
        }

        when (suitnum) {
            1 -> showToast("ID", user)
            2 -> showToast("PW", user)
            3 -> showToast("NICKNAME", user)
            4 -> showToast("MBTI", user)
            5 -> showToast("ABOUTME", user)
            0 -> return true
        }
        return false
    }

    private fun signupButton() {
        binding.tvSignUpEnd.setOnClickListener {
            val user = addData()
            if (suitability(user)) {
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra("user_data", user)
                startActivity(intent)
            }
        }
    }


}