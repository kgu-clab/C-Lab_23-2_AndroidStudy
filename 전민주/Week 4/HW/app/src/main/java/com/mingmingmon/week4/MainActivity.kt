package com.mingmingmon.week4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.mingmingmon.week4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var activityResultLancher: ActivityResultLauncher<Intent>
    //var user: User? = null
    private val REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedUser: User? = intent.getParcelableExtra("USER") as? User
        if (receivedUser != null) {
            binding.activityMainTvId.setText(receivedUser!!.id.toString())
            binding.activityMainTvNickName.setText(receivedUser!!.nickname.toString())
            binding.activityMainTvMBTI.setText(receivedUser!!.mbti.toString())
            binding.activityMainTvAboutMe.setText(receivedUser!!.aboutMe.toString())
        }
        /*binding.activityMainTvId.setText("아이고 진짜 왜 안돼")
        warningToast("메인")*/

        /*var activityResultLancher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data: Intent? = result.data
                    if (data != null) {
                        user = data?.getParcelableExtra("USER", User::class.java)
                        binding.activityMainTvId.setText(user!!.id.toString())
                        binding.activityMainTvNickName.setText(user!!.nickname.toString())
                        binding.activityMainTvMBTI.setText(user!!.mbti.toString())
                        binding.activityMainTvAboutMe.setText(user!!.aboutMe.toString())
                    } else
                        warningToast("회원 정보에 오류가 있습니다.")
                }
            }

        activityResultLancher.launch(
            Intent(this, LoginActivity::class.java).apply {
                this
            }
        )*/

    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.activityMainTvId.setText("함수 실행")
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                user = data?.getParcelableExtra("USER", User::class.java)
                binding.activityMainTvId.setText(user!!.id.toString())
                binding.activityMainTvNickName.setText(user!!.nickname.toString())
                binding.activityMainTvMBTI.setText(user!!.mbti.toString())
                binding.activityMainTvAboutMe.setText(user!!.aboutMe.toString())
            }
        }
    }*/

}

