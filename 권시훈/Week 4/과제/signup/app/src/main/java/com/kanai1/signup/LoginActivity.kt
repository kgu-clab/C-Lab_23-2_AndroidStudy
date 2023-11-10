package com.kanai1.signup

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.kanai1.signup.databinding.ActivityLoginBinding
import java.io.Serializable

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var userinfo: userInfoClass? = null
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        userinfo = it.data?.getSerializableExtra("userInfo", userInfoClass::class.java)
        setID(userinfo?.id)
        setPassword(userinfo?.password)
        /*
        위에 널처리를 한 다음에 블럭으로 코드를 작성했는데도 오류가 나서 !!연산자를 사용했던거에요.
        null이 들어와도 처리가능한 함수로 변경했습니다!
         */
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityLoginTvSignup.setOnClickListener{
            val signupIntent = Intent(this, SignupActivity::class.java)
            resultLauncher.launch(signupIntent)
        }

        binding.activityLoginBtnLogin.setOnClickListener{
            if(userinfo == null) {
                showToast("유저정보가 없습니다")
            }
            else {
                val mypageIntent = Intent(this, MypageActivity::class.java)
                mypageIntent.putExtra("userInfo", userinfo)
                startActivity(mypageIntent)
                showToast("로그인 성공")
            }
        }
    }
}