package com.jiyoxn.study

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jiyoxn.study.databinding.ItemFriendBinding
import com.jiyoxn.study.databinding.ItemMyBinding

class HumanAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    val VIEW_TYPE_FRIEND = 0
    val VIEW_TYPE_MY = 1

    // 임시의 빈 리스트
    private var humanList: List<Human> = emptyList()

    override fun getItemViewType(position: Int): Int {
        return when (humanList[position]) {
            is Human.Friend -> VIEW_TYPE_FRIEND
            is Human.My -> VIEW_TYPE_MY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_MY -> {
                val binding = ItemMyBinding.inflate(inflater, parent, false)
                MyViewHolder(binding)
            }
            VIEW_TYPE_FRIEND -> {
                val binding = ItemFriendBinding.inflate(inflater, parent, false)
                FriendViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MyViewHolder -> {
                holder.onBind(humanList[position] as Human.My)
            }
            is FriendViewHolder -> {
                holder.onBind(humanList[position] as Human.Friend)
            }
        }
    }

    override fun getItemCount() = humanList.size

    // 임시 리스트에 준비해둔 가짜 리스트를 연결하는 함수
    fun setHumanList(mockHumanList: List<Human>) {
        this.humanList = mockHumanList.toList()
        notifyDataSetChanged()
    }
}