package com.mingmingmon.myapplication


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mingmingmon.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding
    private lateinit var activityResultLancher: ActivityResultLauncher<Intent>
    var user: User? = null

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate((layoutInflater))
        setContentView(binding.root)

        getUserInfoFromSignUPActivity()
        clickSignUpButton()
        clickLoginButton()

    }

    private fun getUserInfoFromSignUPActivity(){
        activityResultLancher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data: Intent? = result.data
                if (data != null) {
                    user = data?.getParcelableExtra("USER", User::class.java)
                    binding.activityLoginEtID.setText(user!!.id)
                    binding.activityLoginEtPassword.setText(user!!.password)
                }
                else
                    warningToast("회원정보가 비어있습니다. 확인해주세요.")
            }
        }
    }

    private fun clickSignUpButton(){
        val signUpButton = binding.activityLoginBtnJoin.setOnClickListener{
            activityResultLancher.launch(
                Intent(this, SignUpActivity::class.java).apply {
                    this
                }
            )
        }
    }

    private fun clickLoginButton(){
        val logInButton = binding.activityLoginBtnLogin.setOnClickListener{
            val enteredId = binding.activityLoginEtID.text.toString()
            val enteredPassWord = binding.activityLoginEtPassword.text.toString()

            if(user == null)
                warningToast("회원 정보가 없습니다.")
            else{
                if(user!!.id != enteredId)
                    warningToast("존재하지 않는 아이디 입니다.")
                else if(user!!.password != enteredPassWord)
                    warningToast("비밀번호가 알맞지 않습니다.")
                else{
                    val loginToMainIntent = Intent(this, MainActivity::class.java)
                    loginToMainIntent.putExtra("USER", user)
                    setResult(RESULT_OK, loginToMainIntent)
                    startActivity(loginToMainIntent)
                    finish()
                }
            }
        }
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