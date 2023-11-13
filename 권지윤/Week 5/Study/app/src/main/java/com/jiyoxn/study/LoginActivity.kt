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
    var receivedIntroduce: String = ""

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
                    receivedIntroduce = data?.getStringExtra("introduce") ?: ""

                    binding.editId.setText(receivedId)
                    binding.editTextPassword.setText(receivedPw)
                }
            }

        binding.signUpTextView.setOnClickListener {
            val signUpIntent = Intent(this, SignupActivity::class.java)
            activityResultLauncher.launch(signUpIntent)
        }

        binding.loginbtn.setOnClickListener {
            val id = binding.editId.text.toString()
            val pw = binding.editTextPassword.text.toString()

            if (id == receivedId && pw == receivedPw) {
                Intent(this, MainActivity::class.java).apply {
                    intent.putExtra("id", receivedId)
                    intent.putExtra("pw", receivedPw)
                    intent.putExtra("name", receivedName)
                    intent.putExtra("mbti", receivedMbti)
                    intent.putExtra("introduce", receivedIntroduce)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(this)
                    finish()
                   }
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
