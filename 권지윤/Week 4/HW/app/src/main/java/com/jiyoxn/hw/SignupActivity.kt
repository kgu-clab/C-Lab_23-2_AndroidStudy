package com.jiyoxn.hw

import android.content.Intent
import android.content.LocusId
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jiyoxn.hw.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SignUpBtn.setOnClickListener{
            val id=binding.editID.text.toString()
            val pw=binding.editPW.text.toString()
            val name=binding.editName.text.toString()
            val mbti=binding.editMBTI.text.toString()
            val introduce=binding.editME.text.toString()

            if(validInput(id,pw,name,mbti,introduce)) {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("id",id)
                intent.putExtra("pw",pw)
                intent.putExtra("name",name)
                intent.putExtra("mbti",mbti)
                intent.putExtra("introduce",introduce)
                startActivity(intent)
            }
        }
    }
    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    fun isLetters(string: String): Boolean {
        for (c in string)
        {
            if (c !in 'A'..'Z' && c !in 'a'..'z') {
                return false
            }
        }
        return true
    }
    fun validInput(id:String, pw:String, name: String,mbti:String,introduce:String): Boolean {
        if(id.length<5 || id.length>11){
            showToast("ID는 6~10 글자")
            return false
        }
        if(pw.length<8 || pw.length>12){
            showToast("PW는 8~12 글자")
            return false
        }
        if (name.trim().length<1){
            showToast("닉네임은 공백제외 1글자 이상")
            return false
        }
        if (!isLetters(mbti) || mbti.length!=4){
            showToast("mbti는 알파벳 4글자")
            return false
        }
        if (introduce.trim().length<1) {
            showToast("자기소개는 공백 제외 한 글자 이상")
            return false
        }
        return true
    }


}

