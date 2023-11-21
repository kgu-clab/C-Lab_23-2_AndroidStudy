package com.mingmingmon.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mingmingmon.myapplication.databinding.ItemMeBinding


class MeViewHolder (private val binding: ItemMeBinding) :
    RecyclerView.ViewHolder(binding.root){

        fun onBindView(MeData: UIModel.Me) {
            binding.itemMeImage.setImageResource(MeData.image)
            binding.itemMeTvId.text = MeData.id
            binding.itemMeTvSelfInfo.text = MeData.aboutMe

            binding.itemMeTvBirthDay.visibility = MeData.birthDay.let{
                if(it) View.VISIBLE else View.GONE
            }
        }

}