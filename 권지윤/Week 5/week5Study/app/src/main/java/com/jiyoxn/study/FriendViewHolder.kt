package com.jiyoxn.study

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jiyoxn.study.databinding.FragmentMypageBinding
import com.jiyoxn.study.databinding.ItemFriendBinding
import java.util.Date

class FriendViewHolder(private val binding: ItemFriendBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(friendDate: Human.Friend) {
        with(binding){
            itemFriendImg.setImageResource(friendDate.profileImage)
            itemFriendTvName.text=friendDate.name
            itemFriendSelfDescription.text=friendDate.selfDescription
            if (friendDate.birthDay) {
                itemFriendTvBirthDay.visibility = View.VISIBLE
            } else {
                itemFriendTvBirthDay.visibility = View.GONE
            }
        }

    }

}