package com.mingmingmon.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mingmingmon.myapplication.databinding.ItemFriendBinding

class FriendViewHolder (private val binding: ItemFriendBinding) :
    RecyclerView.ViewHolder(binding.root){

        fun onBindView(friendData: UIModel.Friend) {
            binding.itemFriendImage.setImageResource(friendData.image)
            binding.itemFriendTvId.text = friendData.id
            binding.itemFriendTvSelfInfo.text = friendData.aboutMe

            binding.itemFriendTvBirthDay.visibility = friendData.birthDay.let{
                if(it) View.VISIBLE else View.GONE
            }
        }

}