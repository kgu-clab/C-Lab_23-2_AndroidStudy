package com.kanai1.signup

import androidx.recyclerview.widget.RecyclerView
import com.kanai1.signup.databinding.ItemMeBinding


class MeViewHolder(private val binding: ItemMeBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(friendData: Human.Me) {
        with(binding) {
            ivProfile.setImageResource(friendData.profileImage)
            tvName.text = friendData.name
            tvAboutMe.text = friendData.aboutMe
        }
    }
}