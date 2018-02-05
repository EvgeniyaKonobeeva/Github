package com.example.user.myapplication.network.retrofit

import android.os.Parcel
import android.os.Parcelable


class ResponseTokenModel() : Parcelable {
    var id: Long? = null
    var token: String? = null
    var hashedToken: String? = null
    var accessToken: String? = null
    var tokenType: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        token = parcel.readString()
        hashedToken = parcel.readString()
        accessToken = parcel.readString()
        tokenType = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(token)
        parcel.writeString(hashedToken)
        parcel.writeString(accessToken)
        parcel.writeString(tokenType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseTokenModel> {
        override fun createFromParcel(parcel: Parcel): ResponseTokenModel {
            return ResponseTokenModel(parcel)
        }

        override fun newArray(size: Int): Array<ResponseTokenModel?> {
            return arrayOfNulls(size)
        }
    }


}
