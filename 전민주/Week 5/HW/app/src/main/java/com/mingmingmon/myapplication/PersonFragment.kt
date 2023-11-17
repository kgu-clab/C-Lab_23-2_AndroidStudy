package com.mingmingmon.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mingmingmon.myapplication.databinding.FragmentPersonBinding

class PersonFragment: Fragment() {
    private var _binding: FragmentPersonBinding? = null
    private val binding: FragmentPersonBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았다. 생성하고 불러라 임마!" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<User>(ARG_USER)

        binding.fragementPersonTvId.setText(user!!.id.toString())
        binding.fragementPersonTvNickName.setText(user!!.nickname.toString())
        binding.fragementPersonTvMBTI.setText(user!!.mbti.toString())
        binding.fragementPersonTvAboutMe.setText(user!!.aboutMe.toString())
    }

    companion object {
        private const val ARG_USER = "USER"

        fun newInstance(user: User): PersonFragment{
            val fragment = PersonFragment()
            val args = Bundle()
            args.putParcelable(ARG_USER, user)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}