package com.mingmingmon.week4


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.mingmingmon.week4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding
    private lateinit var activityResultLancher: ActivityResultLauncher<Intent>
    var user: User? = null

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate((layoutInflater))
        setContentView(binding.root) // 알맞은 xml 파일과 바인딩

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

        // 회원가입하기 버튼 누르면 회원가입하는 화면으로 이동
        val signUpButton = binding.activityLoginBtnJoin.setOnClickListener{
            activityResultLancher.launch(
                Intent(this, SignUpActivity::class.java).apply {
                    this
                }
            )
        }

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
        //String으로 상황에 맞는 경고 메세지를 받아서 토스트로 띄움
        val text = inputText
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }

    // 회원가입 페이지에서 값 받을 때 필요한 메소드
    // 개발자가 직접 호출하는게 아니라 데이터를 전달하는 액티비티에서 setResult()로 결과 설정하고
    // 전달하는 액티비티가 종료될 때 호출됨.
    /*private fun handleActivityResult() {
        if (data == null) {
            warningToast("회원정보가 비어있습니다. 확인해주세요.")
        } else {
            binding.activityLoginEtID.setText(user!!.id.toString())
            binding.activityLoginEtPassword.setText(user!!.password.toString())
        }
    }*/
}