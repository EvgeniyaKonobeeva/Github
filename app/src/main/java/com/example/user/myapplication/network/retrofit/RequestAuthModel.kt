package com.example.user.myapplication.network.retrofit

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Evgeniya on 04.02.2018.
 */
class RequestAuthModel() : Parcelable {
    var clientId: String? = null
    var clientSecret: String? = null
    var redirectUri: String? = null
    var scopes: List<String>? = null
    var state: String? = null
    var note: String? = null
    var noteUrl: String? = null

    @SerializedName("X-GitHub-OTP")
    private var otpCode: String? = null

    constructor(parcel: Parcel) : this() {
        clientId = parcel.readString()
        clientSecret = parcel.readString()
        redirectUri = parcel.readString()
        scopes = parcel.createStringArrayList()
        state = parcel.readString()
        note = parcel.readString()
        noteUrl = parcel.readString()
        otpCode = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(clientId)
        parcel.writeString(clientSecret)
        parcel.writeString(redirectUri)
        parcel.writeStringList(scopes)
        parcel.writeString(state)
        parcel.writeString(note)
        parcel.writeString(noteUrl)
        parcel.writeString(otpCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RequestAuthModel> {
        override fun createFromParcel(parcel: Parcel): RequestAuthModel {
            return RequestAuthModel(parcel)
        }

        override fun newArray(size: Int): Array<RequestAuthModel?> {
            return arrayOfNulls(size)
        }
    }




}