package com.kanai1.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.Toast
import com.kanai1.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val text = binding.editTextText.text.toString()
            Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

/*
Top: 위/ Bottom: 아래/ Start: 왼쪽/ End: 오른쪽
constraint -> 컴포넌트끼리 상대적인 위치를 지정해주는 방식

dp는 화면크기에 따른 보정이 있긴함
근데 크게 움직일때는 따로 세팅하는게 좋음

View Binding
내가 지정하는 View에서만 무언가를 처리하는것
Gradle Scripts/build.gradle.kts에
    buildFeatures {
        viewBinding = true
    }
를 추가해주면 사용가능

lateinit: 나중에 선언하기, 메모리 아낄수있음
 */