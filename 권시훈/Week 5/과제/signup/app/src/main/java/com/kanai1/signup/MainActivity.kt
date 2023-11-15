package com.kanai1.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kanai1.signup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickBottomNavigation()
        binding.activityMainDnvHome.selectedItemId = binding.activityMainDnvHome.menu.getItem(1).itemId
    }

    private fun clickBottomNavigation() {
        binding.activityMainDnvHome.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_home-> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_mypage-> {
                    var fragment = MypageFragment()
                    var userInfo = intent.getParcelableExtra("userInfo", userInfoClass::class.java)
                    fragment.setUserInfo(userInfo)
                    replaceFragment(fragment)
                    true
                }

                R.id.menu_message-> {
                    replaceFragment(MessageFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_login_fcvHome, fragment)
            .commit()
    }

}
