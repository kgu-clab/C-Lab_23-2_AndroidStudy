package com.tnals.week5_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tnals.week5_hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFirstFragment()
        clickBottomNavigation()
    }

    private fun setFirstFragment() {
        binding.bnvHome.selectedItemId = binding.bnvHome.menu.getItem(1).itemId
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction().add(R.id.fcv_home, MainFragment())
                .commit()
        }
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener {
            val data = intent.getParcelableExtra<User>("user_data")
            when (it.itemId) {
                R.id.menu_message -> {
                    replaceFragment(MessageFragment())
                    true
                }

                R.id.menu_home -> {
                    replaceFragment(MainFragment())
                    true
                }

                R.id.menu_profile -> {
                    if (data != null) {
                        val fragment = MyPageFragment()
                        val args = Bundle()
                        args.putParcelable("user_data", data)
                        fragment.arguments = args
                        replaceFragment(fragment)
                    }

                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fcv_home, fragment).commit()
    }
}