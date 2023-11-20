package com.tnals.week5_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tnals.week5_hw.databinding.ActivitySignupBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signupButton()

    }

    private fun signupButton() {
        binding.tvSignUpEnd.setOnClickListener {
            val user = addData()
            if (suitability(user) == 0) {
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("user_data", user)
                }
                setResult(RESULT_OK, intent)
                if (!isFinishing) finish()
            } else {
                showToast(suitability(user), user)
            }
        }
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

    private fun suitability(
        user: User
    ): Int {
        if (user.aboutme.isEmpty())
            return 5
        if (user.aboutme.isNotEmpty()) {
            for (element in user.aboutme) {
                if (element == ' ') {
                    return 5
                }
            }
        }

        if (user.mbti.length != 4)
            return 4
        else {
            if (!((user.mbti[0] == 'E' || user.mbti[0] == 'I') && (user.mbti[1] == 'S' || user.mbti[1] == 'N'
                        ) && (user.mbti[2] == 'T' || user.mbti[2] == 'F') && (user.mbti[3] == 'J' || user.mbti[3] == 'P'))
            )
                return 4
        }

        if (user.nickname.isEmpty())
            return 3
        if (user.nickname.isNotEmpty()) {
            for (element in user.nickname) {
                if (element == ' ') {
                    return 3
                }
            }
        }

        if (user.pw.length < 8 || user.pw.length > 12) {
            return 2
        }

        if (user.id.length < 6 || user.id.length > 10) {
            return 1
        }
        return 0
    }

    private fun showToast(data: Int, user: User) {
        var errorText = " "
        if (data == 1)
            errorText = getString(R.string.error_id, user.id.length)
        if (data == 2)
            errorText = getString(R.string.error_pw, user.pw.length)
        if (data == 3)
            errorText = getString(R.string.error_name)
        if (data == 4)
            errorText = getString(R.string.error_mbti)
        if (data == 5)
            errorText = getString(R.string.error_about)
        Toast.makeText(
            this,
            errorText,
            Toast.LENGTH_SHORT
        ).show()
    }
}