package com.kanai1.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kanai1.signup.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding: FragmentMypageBinding
        get() = requireNotNull(_binding) {"_binding is null"}

    private var userInfo: userInfoClass? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProfile()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setProfile() {
        var userinfo = getUserInfo()
        if(userinfo != null) {
            with(binding){
                fragmentMypageTvID.setText("id: ${userinfo.id}")
                fragmentMypageTvNickname.setText("nickname: ${userinfo.nickname}")
                fragmentMypageTvMBTI.setText("MBTI: ${userinfo.MBTI}")
                fragmentMypageTvAboutMe.setText("AboutMe: ${userinfo.AboutMe}")
            }
        }
    }

    fun setUserInfo(userInfo: userInfoClass?) {this.userInfo = userInfo}
    fun getUserInfo() = this.userInfo
}