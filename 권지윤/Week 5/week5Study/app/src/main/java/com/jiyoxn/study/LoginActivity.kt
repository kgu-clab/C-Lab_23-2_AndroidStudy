package com.jiyoxn.study

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.jiyoxn.study.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    var receivedId: String = ""
    var receivedPw: String = ""
    var receivedName: String = ""
    var receivedMbti: String = ""
    var receivedMe: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data: Intent? = result.data
                    receivedId = data?.getStringExtra("id") ?: ""
                    receivedPw = data?.getStringExtra("pw") ?: ""
                    receivedName = data?.getStringExtra("name") ?: ""
                    receivedMbti = data?.getStringExtra("mbti") ?: ""
                    receivedMe = data?.getStringExtra("me") ?: ""

                    binding.activityLoginEtId.setText(receivedId)
                    binding.activityLoginEtPw.setText(receivedPw)
                }
            }

        binding.activityLoginTvSignup.setOnClickListener {
            val signUpIntent = Intent(this, SignupActivity::class.java)
            activityResultLauncher.launch(signUpIntent)
        }

        binding.activityLoginBtnLogin.setOnClickListener {
            val id = binding.activityLoginEtId.text.toString()
            val pw = binding.activityLoginEtPw.text.toString()

            if (id == receivedId && pw == receivedPw) {
                val homeActivityIntent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("id", receivedId)
                    putExtra("pw", receivedPw)
                    putExtra("name", receivedName)
                    putExtra("mbti", receivedMbti)
                    putExtra("me", receivedMe)
                }

                homeActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(homeActivityIntent)
                finish()

                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
