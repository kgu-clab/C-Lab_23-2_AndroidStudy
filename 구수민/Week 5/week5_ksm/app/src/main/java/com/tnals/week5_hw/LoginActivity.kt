package com.tnals.week5_hw

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.tnals.week5_hw.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userDataList = mutableListOf<User>()
        inputData(userDataList)
        goLogin(userDataList)
        goSignUp()

    }

    private fun inputData(userDataList: MutableList<User>) {
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val data: Intent? = it.data
                val user: User? = data?.getParcelableExtra("user_data")
                if (user != null) {
                    binding.inputID.text = Editable.Factory.getInstance().newEditable(user.id)
                    binding.inputPassword.text = Editable.Factory.getInstance().newEditable(user.pw)
                    userDataList.add(user)
                }
            }
        }
    }

    private fun goLogin(userDataList: MutableList<User>) {
        binding.tvMainLogin.setOnClickListener {
            val id = binding.inputID.text.toString()
            val pw = binding.inputPassword.text.toString()
            var exist = false
            userDataList.forEach {
                if (it.id == id && it.pw == pw) {
                    val loginIntent = Intent(this, MainActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
                    loginIntent.putExtra("user_data", it)
                    val text = "Login Success"
                    Toast.makeText(
                        this,
                        text,
                        Toast.LENGTH_SHORT
                    ).show()
                    exist = true
                    startActivity(loginIntent)
                    finish()
                }
            }
            if (!exist) {
                val text = "User information does not exist."
                Toast.makeText(
                    this,
                    text,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun goSignUp() {
        binding.tvMainSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}