package com.jiyoxn.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jiyoxn.study.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았다. 생성하고 불러라 임마!" }

    private val mockHumanList= listOf<Human>(
        Human.My(
            profileImage = R.drawable.ic_person_gray_24,
            name = "권지윤",
            selfDescription = "내 소개",
            birthDay=true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구1",
            selfDescription="한줄소개1",
            birthDay = true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구2",
            selfDescription="한줄소개2",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구3",
            selfDescription="한줄소개3",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구4",
            selfDescription="한줄소개4",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구5",
            selfDescription="한줄소개5",
            birthDay = true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구6",
            selfDescription="한줄소개6",
            birthDay = false
        ),Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구7",
            selfDescription="한줄소개7",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구8",
            selfDescription="한줄소개8",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구9",
            selfDescription="한줄소개9",
            birthDay = false
        ),Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구10",
            selfDescription="한줄소개10",
            birthDay = true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구11",
            selfDescription="한줄소개11",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구12",
            selfDescription="한줄소개12",
            birthDay = false
        ),Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구13",
            selfDescription="한줄소개13",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구14",
            selfDescription="한줄소개14",
            birthDay = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_person_gray_24,
            name="친구15",
            selfDescription="한줄소개15",
            birthDay = true
        )

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // 이제 반환하는 View가 Null일 수 없기 때문에, ?를 지워주셔도 됩니다.
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 대부분의 로직은 여기에 구현합니다.
        // 원두를 갈고~
        // 커피를 내리고~
        val humanAdapter=HumanAdapter(requireContext())
        binding.rvHumans.adapter=humanAdapter
        humanAdapter.setHumanList((mockHumanList))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}