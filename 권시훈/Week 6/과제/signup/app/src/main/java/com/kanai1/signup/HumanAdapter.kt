package com.kanai1.signup

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kanai1.signup.databinding.ItemFriendBinding
import com.kanai1.signup.databinding.ItemMeBinding
import java.lang.reflect.Executable

class HumanAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    // 임시의 빈 리스트
    private var humanList: List<Human> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ME_VIEW_TYPE -> HumanViewHolder.MeViewHolder(ItemMeBinding.inflate(inflater, parent, false))
            FRIEND_VIEW_TYPE -> HumanViewHolder.FriendViewHolder(ItemFriendBinding.inflate(inflater, parent, false))
            else -> throw Exception("unknown type!!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HumanViewHolder.MeViewHolder -> holder.onBind(humanList[position] as Human.Me)
            is HumanViewHolder.FriendViewHolder -> holder.onBind(humanList[position] as Human.Friend)
        }
    }

    override fun getItemCount() = humanList.size

    // 임시 리스트에 준비해둔 가짜 리스트를 연결하는 함수
    fun setFriendList(humanList: List<Human>) {
        this.humanList = humanList.toList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when(humanList[position]) {
            is Human.Me -> ME_VIEW_TYPE
            is Human.Friend -> FRIEND_VIEW_TYPE
            else -> throw Exception("unknown type")
        }
    }

    companion object {
        const val ME_VIEW_TYPE = 0
        const val FRIEND_VIEW_TYPE = 1
    }
}