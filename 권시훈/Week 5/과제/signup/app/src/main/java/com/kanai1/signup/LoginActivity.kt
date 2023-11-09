package com.kanai1.signup

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.kanai1.signup.databinding.ActivityLoginBinding
import java.io.Serializable

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var userinfo: userInfoClass? = null
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBinding()
    }

    fun setBinding() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            userinfo = it.data?.getParcelableExtra("userInfo", userInfoClass::class.java)
            setID(userinfo?.id)
            setPassword(userinfo?.password)
        }

        binding.activityLoginTvSignup.setOnClickListener{
            val signupIntent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(signupIntent)
        }

        binding.activityLoginBtnLogin.setOnClickListener{
            if(userinfo == null) {
                showToast("유저정보가 없습니다")
            }
            else {
                val mypageIntent = Intent(this, MainActivity::class.java)
                mypageIntent.putExtra("userInfo", userinfo)
                mypageIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(mypageIntent)
                showToast("로그인 성공")
            }
        }
    }

    fun setID(id: String?) {
        binding.activityLoginEtID.setText(id?:"")
    }

    fun setPassword(password: String?) {
        binding.activityLoginEtPassword.setText(password?:"")
    }

    fun showToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
}