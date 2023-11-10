package com.mingmingmon.week4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize // 이거 import 꼭 하기

@Parcelize
data class User(
    var id: String?,
    var password : String?,
    var nickname : String?,
    var mbti : String?,
    var aboutMe : String?
) : Parcelable