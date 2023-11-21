package com.kanai1.signup

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class userInfoClass(
    var id: String,
    var password: String,
    var nickname: String,
    var MBTI: String,
    var AboutMe: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(password)
        dest.writeString(nickname)
        dest.writeString(MBTI)
        dest.writeString(AboutMe)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<userInfoClass> {
        override fun createFromParcel(parcel: Parcel): userInfoClass {
            return userInfoClass(parcel)
        }

        override fun newArray(size: Int): Array<userInfoClass?> {
            return arrayOfNulls(size)
        }
    }
}
