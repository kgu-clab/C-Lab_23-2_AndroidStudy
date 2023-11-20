package com.jiyoxn.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jiyoxn.study.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    var receivedId:String?=null
    var receivedPw:String?=null
    var receivedName:String?=null
    var receivedMbti:String?=null
    var receivedMe:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receivedId = intent.getStringExtra("id")
        receivedPw = intent.getStringExtra("pw")
        receivedName = intent.getStringExtra("name")
        receivedMbti = intent.getStringExtra("mbti")
        receivedMe = intent.getStringExtra("me")

//맨처음에 홈
      //  binding.activityHomeBnvHome.selectedItemId = R.id.menu_home

        val currentFragment = supportFragmentManager.findFragmentById(R.id.activity_home_fcv_home)
        if (currentFragment == null){
            binding.activityHomeBnvHome.selectedItemId = R.id.menu_home
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_home_fcv_home,HomeFragment())
                .commit()
        }

        clickBottomNavigation()

    }
    // 바텀 네비게이션을 클릭 했을 때? -> 사용자가 누른 아이템(메뉴의 아이템)에 따라 when문을 통해 해당하는 Fragment를 담아서 함수를 실행합니다.
// true와 false는 리스너에게 Fragment 교체 작업을 정상적으로 처리했다는 것을 알려주기 위해서 작성합니다.
    private fun clickBottomNavigation() {

        binding.activityHomeBnvHome.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_home-> {
                    replaceFragment(HomeFragment())
                    true//이동된거 알려줌
                }

                R.id.menu_mypage-> {
                    replaceFragment(MypageFragment())

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

    // Activity에서 Fragment를 다뤄야 하니 supportFragmentManager를 사용합니다.
// 트렌젝션을 시작하고 replace 메서드를 통해 Fragment를 교체합니다.
    private fun replaceFragment(fragment: Fragment) {
        setDataAtFragment(fragment)
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_home_fcv_home, fragment)
            .commit()
    }
    fun setDataAtFragment(fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString("receivedId", receivedId)
        bundle.putString("receivedPw", receivedPw)
        bundle.putString("receivedName", receivedName)
        bundle.putString("receivedMbti", receivedMbti)
        bundle.putString("receivedMe", receivedMe)
        fragment.arguments = bundle
    }
}
