package com.kanai1.signup

import java.io.Serializable

data class userInfoClass(
    var id: String,
    var password: String,
    var nickname: String,
    var MBTI: String,
    var AboutMe: String
): Serializable
