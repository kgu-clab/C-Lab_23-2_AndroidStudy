package com.mingmingmon.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.mingmingmon.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var receivedUser: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnvHome.menu.findItem(R.id.menu_home).isChecked = true;
        getUserInfo(receivedUser)
        setFragment()
        clickBottomNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)

        // 처음 선택되어야 하는 메뉴 아이템에 setChecked(true) 호출
        val initialMenuItem: MenuItem? = menu.findItem(R.id.menu_home)
        initialMenuItem?.isChecked = true

        return true
    }

    private fun getUserInfo(receivedUser : User?){
        this.receivedUser = intent.getParcelableExtra("USER") as? User
    }

    private fun setFragment(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if(currentFragment == null){
            supportFragmentManager.beginTransaction().add(R.id.fcv_home, MainFragment()).commit()
        }
    }



    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_home-> {
                    replaceFragment(MainFragment())
                    true
                }

                R.id.menu_message-> {
                    replaceFragment(MessageFragment())
                    true
                }

                R.id.menu_person-> {
                    val mypageFragment = PersonFragment.newInstance(receivedUser!!)
                    replaceFragment(mypageFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }
}