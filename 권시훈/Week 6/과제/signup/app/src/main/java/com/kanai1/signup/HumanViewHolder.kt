package com.kanai1.signup

import androidx.recyclerview.widget.RecyclerView
import com.kanai1.signup.databinding.ItemFriendBinding
import com.kanai1.signup.databinding.ItemMeBinding

sealed class HumanViewHolder{
    abstract fun onBind(item: Human)

    class FriendViewHolder(private val binding: ItemFriendBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(friendData: Human.Friend) {
            with(binding) {
                ivProfile.setImageResource(friendData.profileImage)
                tvName.text = friendData.name
                tvAboutMe.text = friendData.aboutMe
                if(friendData.isBirthday) {
                    ivBirthday.setImageResource(R.drawable.ic_cake_black_24)
                }
            }
        }
    }

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
}
