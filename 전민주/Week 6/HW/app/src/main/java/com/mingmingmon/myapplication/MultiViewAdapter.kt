package com.mingmingmon.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mingmingmon.myapplication.databinding.ItemFriendBinding
import com.mingmingmon.myapplication.databinding.ItemMeBinding

class MultiViewAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
   /* private val inflater by lazy { LayoutInflater.from(context) }*/
    private val VIEW_TYPE_ME = 1300005
    private val VIEW_TYPE_FRIEND = 1300000

    // 임시의 빈 리스트
    private var arrayList: List<UIModel> = emptyList()
    //private var friendList: List<Friend> = emptyList()
    fun submitList(list: List<UIModel>){
        this.arrayList = list.toList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = arrayList.size

   /* override fun getItemViewType(position: Int) = when (arrayList[position]) {
        *//*is UIModel.Friend -> R.layout.item_friend
        is UIModel.Me -> R.layout.item_me*//*
        is UIModel.Friend -> VIEW_TYPE_ME
        is UIModel.Me -> VIEW_TYPE_FRIEND
    }*/

    override fun getItemViewType(position: Int): Int {
        val viewType = when (arrayList[position]) {
            is UIModel.Friend -> VIEW_TYPE_FRIEND
            is UIModel.Me -> VIEW_TYPE_ME
            else -> {
                Log.e("MultiViewAdapter", "Unexpected UIModel type at position $position")
                throw IllegalArgumentException("존재하지 않는 뷰입니다.")
            }
        }
        Log.d("MultiViewAdapter", "ViewType for position $position: $viewType")
        return viewType
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        /*val v = layoutInflater.inflate(viewType, parent, false)*/

        return when(viewType){
            VIEW_TYPE_FRIEND -> {
                val binding = ItemFriendBinding.inflate(layoutInflater, parent, false)
                FriendViewHolder(binding)
            }
            VIEW_TYPE_ME -> {
                val binding = ItemMeBinding.inflate(layoutInflater, parent, false)
                MeViewHolder(binding)
            }
            else -> {
                Log.e("MultiViewAdapter", "Unexpected ViewType: $viewType")
                throw IllegalArgumentException("존재하지 않는 뷰입니다.")
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = arrayList[position]

        when(holder){
            /*is FriendViewHolder -> holder.onBindView(item as UIModel.Friend)
            is MeViewHolder -> holder.onBindView(item as UIModel.Me)*/
            is FriendViewHolder -> holder.onBindView(item as UIModel.Friend)
            is MeViewHolder -> holder.onBindView(item as UIModel.Me)
        }
    }


    // 임시 리스트에 준비해둔 가짜 리스트를 연결하는 함수
   /* fun setFriendList(friendList: List<UIModel>) {
        this.arrayList = friendList.map {it as UIModel}
        notifyDataSetChanged()
    }*/
/*
    fun setMe(me: Me){
        this.
    }*/
}