package com.mingmingmon.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mingmingmon.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if(currentFragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fcv_home, HomeFragment()).commit()
        }

        clickBottomNavigation()

    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_home-> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_message-> {
                    replaceFragment(MessageFragment())
                    true
                }

                R.id.menu_person-> {
                    replaceFragment(PersonFragment())
                    true
                }

                else -> false
            }
        }
    }

    // Activity에서 Fragment를 다뤄야 하니 supportFragmentManager를 사용합니다.
// 트렌젝션을 시작하고 replace 메서드를 통해 Fragment를 교체합니다.
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }
}