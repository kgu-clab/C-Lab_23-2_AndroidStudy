package com.jiyoxn.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jiyoxn.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val text=binding.editID.text.toString()
            Toast.makeText(
                this,
                text,//아이디 가져오기
                //"Hi"하면 글자 뜸
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}