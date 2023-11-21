package com.mingmingmon.myapplication

import android.media.Image
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize // 이거 import 꼭 하기


data class Friend(
    @DrawableRes
    val image : Int,
    val id: String?,
    val aboutMe : String?
)