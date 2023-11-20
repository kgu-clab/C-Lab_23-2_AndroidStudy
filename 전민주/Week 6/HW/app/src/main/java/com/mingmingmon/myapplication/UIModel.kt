package com.mingmingmon.myapplication

import androidx.annotation.DrawableRes

sealed class UIModel {
    data class Friend(
        @DrawableRes
        val image : Int,
        val id: String?,
        val aboutMe : String?,
        val birthDay: Boolean
    ): UIModel()

    data class Me(
        @DrawableRes
        val image : Int,
        val id: String?,
        val aboutMe : String?,
        val birthDay: Boolean
    ): UIModel()
}