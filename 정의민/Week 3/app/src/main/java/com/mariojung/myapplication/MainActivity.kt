package com.mariojung.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mariojung.myapplication.databinding.ActivityMainBinding
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var receivedId: String? = null
    private var receivedPwd: String? = null
    private var receivedNick: String? = null
    private var receivedMbti: String? = null
    private var receivedIntro: String? = null

    private val activityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val data: Intent? = result.data
            receivedId = data?.getStringExtra("id")
            receivedPwd = data?.getStringExtra("pwd")
            receivedNick = data?.getStringExtra("Nick")
            receivedMbti = data?.getStringExtra("Mbti")
            receivedIntro = data?.getStringExtra("Intro")
            if (!receivedId.isNullOrBlank()) {
                // JoinActivity에서 전달받은 값을 사용
                binding.editTextText3.setText(receivedId)
                binding.editTextTextPassword.setText(receivedPwd)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 바인딩 연결
        setContentView(binding.root) // xml과 연동

        binding.button2.setOnClickListener {
            // JoinActivity로 이동
            val intent = Intent(this, JoinActivity::class.java)
            activityResultLauncher.launch(intent) // 회원가입 이동 요청
        }

        binding.button.setOnClickListener{

            val editTextId = binding.editTextText3.text.toString()
            val editTextPwd = binding.editTextTextPassword.text.toString()

            if(editTextId == receivedId){
                if(editTextPwd == receivedPwd){  //로그인 성공시 이동
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("sendId", receivedId)
                    intent.putExtra("sendPwd", receivedPwd)
                    intent.putExtra("sendNick", receivedNick)
                    intent.putExtra("sendMbti", receivedMbti)
                    intent.putExtra("sendIntro", receivedIntro)
                    activityResultLauncher.launch((intent))

                    val okText : String = "Login Success\nHello ${receivedId}"
                    Toast.makeText(
                        this,
                        okText,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(editTextPwd != receivedPwd){
                    val loginFail : String = "Unvalid pwd"
                    Toast.makeText(
                        this,
                        loginFail,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }








}