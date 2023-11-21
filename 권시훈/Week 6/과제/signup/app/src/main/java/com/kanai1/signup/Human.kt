package com.kanai1.signup

import androidx.annotation.DrawableRes

sealed class Human{
    data class Me(
        @DrawableRes val profileImage: Int,
        val name: String,
        val aboutMe: String
    ): Human()

    data class Friend (
        @DrawableRes val profileImage: Int,
        val name: String,
        val aboutMe: String,
        val isBirthday: Boolean
    ): Human()
}