package com.mingmingmon.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mingmingmon.myapplication.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았다. 생성하고 불러라 임마!" }

    private val friendList = listOf<UIModel.Friend>(
        UIModel.Friend(
            image = R.drawable.ic_home_black_24,
            id = "탐앤탐",
            aboutMe = "커피 마실 사람",
            birthDay = false
        ),

        UIModel.Friend(
            image = R.drawable.ic_android_black_24dp,
            id = "구수민",
            aboutMe = "배고프다",
            birthDay = false

        ),

        UIModel.Friend(
            image = R.drawable.ic_message_black_24,
            id = "노태윤",
            aboutMe = "덥다",
            birthDay = true
        ),

        UIModel.Friend(
        image = R.drawable.ic_home_black_24,
        id = "탐앤탐",
        aboutMe = "커피 마실 사람",
            birthDay = false
         ),

        UIModel.Friend(
        image = R.drawable.ic_android_black_24dp,
        id = "구수민",
        aboutMe = "배고프다",
            birthDay = false
        ),

        UIModel.Friend(
        image = R.drawable.ic_message_black_24,
        id = "노태윤",
        aboutMe = "덥다",
            birthDay = false
        ),

        UIModel.Friend(
            image = R.drawable.ic_home_black_24,
            id = "탐앤탐",
            aboutMe = "커피 마실 사람",
            birthDay = false
        ),

        UIModel.Friend(
            image = R.drawable.ic_android_black_24dp,
            id = "구수민",
            aboutMe = "배고프다",
            birthDay = false
        ),

        UIModel.Friend(
            image = R.drawable.ic_message_black_24,
            id = "노태윤",
            aboutMe = "덥다",
            birthDay = false
        )
    )

    private val meData = UIModel.Me(
        image = R.drawable.ic_person_black_24,
        id = "전민주",
        aboutMe = "어렵다",
        birthDay = false
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val multiViewAdapter = MultiViewAdapter(requireContext())
        binding.rvHumans.adapter = multiViewAdapter
        binding.rvHumans.layoutManager = LinearLayoutManager(requireContext()).apply{
            orientation = LinearLayoutManager.VERTICAL
        }

        val data = mutableListOf<UIModel>()
        data.add(meData)
        data.addAll(friendList)
        multiViewAdapter.submitList(data)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}