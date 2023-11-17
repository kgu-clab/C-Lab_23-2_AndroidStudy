package com.kanai1.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kanai1.signup.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //더미데이터
    private var humanLists =  listOf<Human> (
        Human.Me(
            profileImage = R.drawable.ic_launcher_background,
            name = "권시훈",
            aboutMe = "OwO"
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "정의민",
            aboutMe = "이사람 어디감?",
            isBirthday = true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "팀장님 발표 화이팅",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석2",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석2",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석3",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이세계에선 내가 생일?",
            isBirthday = true
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석5",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석6",
            isBirthday = false
        ),
        Human.Friend(
            profileImage = R.drawable.ic_launcher_background,
            name = "이형석",
            aboutMe = "이형석7",
            isBirthday = false
        ),
    )

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) {"_binding is null"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val humanAdapter = HumanAdapter(requireContext())
        binding.FragmentHomeRvFriend.adapter = humanAdapter
        humanAdapter.setFriendList(humanLists)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}