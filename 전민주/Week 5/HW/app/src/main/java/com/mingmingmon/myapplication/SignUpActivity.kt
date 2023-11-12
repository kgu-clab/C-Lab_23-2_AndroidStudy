package com.mingmingmon.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mingmingmon.myapplication.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate((layoutInflater))
        setContentView(binding.root)

        clickSignUpButton()
    }

    private fun clickSignUpButton(){
        val signUpButton = binding.activitySignUpBtnSIGNUP.setOnClickListener{
            val id = binding.activitySignUpEtInputID.text.toString()
            val password = binding.activitySignUpEtInputPassword.text.toString()
            val nickname = binding.activitySignUpEtInputNickName.text.toString()
            val mbti = binding.activitySignUpEtInputMBTI.text.toString()
            val aboutMe = binding.activitySignUpEtInputAboutMe.text.toString()

            if(isAvailableSignUpFormat(id, password, nickname, mbti, aboutMe)){
                val newUser = User(id, password, nickname, mbti, aboutMe)
                //val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("USER", newUser)
                setResult(RESULT_OK, intent)
                //startActivity(intent)
                finish()
            }

        }
    }

    private fun isAvailableSignUpFormat(
        id: String,
        password: String,
        nickname: String,
        mbti: String,
        aboutMe: String): Boolean{

        val idPattern = Regex("[a-zA-Z0-9]{6,10}")
        val passwordPattern = Regex("[a-zA-Z0-9]{8,12}")
        val nicknamePattern = Regex("\\S+")
        val mbtiPattern = Regex("[a-zA-Z]{4}")
        val aboutMePattern = Regex("\\S+")

        if(!id.matches(idPattern)){
            warningToast("id는 6~10 글자로 만들어주세요")
            return false;
        }
        if(!password.matches(passwordPattern)){
            warningToast("비밀번호는 8~12 글자로 설정해주세요")
            return false;
        }
        if(!nickname.matches(nicknamePattern)){
            warningToast("닉네임은 공백제외 1글자 이상으로 만들어주세요")
            return false;
        }
        if(!mbti.matches(mbtiPattern)){
            warningToast("mbti는 영어 알파벳 4글자로 표현해주세요")
            return false;
        }
        if(!aboutMe.matches(aboutMePattern)){
            warningToast("자기소개는 공백제외 1글자 이상으로 적어주세요")
            return false;
        }
        return true;
    }

    private fun warningToast(inputText: String) {
        val text = inputText
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}

