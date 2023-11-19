package com.jiyoxn.study

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jiyoxn.study.databinding.ItemMyBinding
import java.util.Date

class MyViewHolder(private val binding: ItemMyBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(myDate: Human.My) {
        with(binding){
            itemMyImg.setImageResource(myDate.profileImage)
            itemMyTvName.text=myDate.name
            itemMySelfDescription.text=myDate.selfDescription
            if (myDate.birthDay) {
                itemMyTvBirthDay.visibility = View.VISIBLE
            } else {
                itemMyTvBirthDay.visibility = View.GONE
            }
        }
    }
}