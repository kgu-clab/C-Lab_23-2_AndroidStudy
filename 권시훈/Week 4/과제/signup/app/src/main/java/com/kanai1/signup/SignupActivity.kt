package com.kanai1.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kanai1.signup.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    fun getID():String? {
        var id = binding.activitySignupEtID.text.toString()
        return if(id.length in 6..10 && !id.contains(" ")) id else null
    }

    fun getPassword():String? {
        var password = binding.activitySignupEtPassword.text.toString()
        return if(password.length in 8 .. 12 && !password.contains(" ")) password else null
    }

    fun getName(): String? {
        var name = binding.activitySignupEtName.text.toString()
        return if(name.trim().isNotEmpty()) name else null
    }

    fun getMBTI(): String? {
        var MBTI = binding.activitySignupEtMBTI.text.toString()
        return if(MBTI.length == 4 || MBTI.none { it !in 'A'..'Z' && it !in 'a'..'z' }) MBTI else null
    }

    fun getAboutMe(): String? {
        var AboutMe = binding.activitySignupEtAboutMe.text.toString()
        return if(AboutMe.trim().isNotEmpty()) AboutMe else null
    }

    fun showErrorToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activitySignupBtnSignup.setOnClickListener{

            var id = getID()
            var password = getPassword()
            var name = getName()
            var MBTI = getMBTI()
            var AboutMe = getAboutMe()

            if(id == null) showErrorToast("id는 6~8자의 영문 및 숫자를 이용해주세요")
            else if(password == null) showErrorToast("password는 8~12자의 영문 및 숫자를 이용해주세요")
            else if(name == null) showErrorToast("이름은 공백을 제외하고 1자 이상을 이용해주세요")
            else if(MBTI == null) showErrorToast("MBTI는 영문 4글자를 이용해주세요")
            else if(AboutMe == null) showErrorToast("About Me는 공백제외 1자 이상을 이용해주세요")
            else{
                var userinfo = userInfoClass(id, password, name, MBTI, AboutMe)
                val loginIntent = Intent(this, LoginActivity::class.java).apply{
                    putExtra("userInfo", userinfo)
                }

                setResult(RESULT_OK, loginIntent)
                if(!isFinishing) finish()
            }


        }
    }
}