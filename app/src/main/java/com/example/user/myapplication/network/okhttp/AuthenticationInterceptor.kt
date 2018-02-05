package com.example.user.myapplication.network.okhttp

import android.content.ContentValues.TAG
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthenticationInterceptor(private val userNamePassword: String, private val optCode: String?): Interceptor {
    val TAG = "AuthenticationInterceptor"
    @Throws(IOException::class) override fun intercept(chain: Interceptor.Chain): Response{

        Log.d(TAG, "intercept: userNamePassword= $userNamePassword");

        val builder = chain.request().newBuilder()

        if(!userNamePassword.isBlank()){
            builder.header("Authorization", userNamePassword)
        }
        if (!optCode.isNullOrBlank()) {
            builder.addHeader("X-GitHub-OTP", "$optCode")
        }

        val request = builder.build()
        return chain.proceed(request)
    }
}