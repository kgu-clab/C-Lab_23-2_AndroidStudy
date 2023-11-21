package com.jiyoxn.study

import androidx.annotation.DrawableRes

sealed class Human{
    data class Friend(
        @DrawableRes
        val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val birthDay: Boolean
    ):Human()

    data class My(
        @DrawableRes
        val profileImage: Int,
        val name: String,
        val selfDescription: String,
        val birthDay: Boolean
    ): Human()
}