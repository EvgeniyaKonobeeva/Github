package com.example.user.myapplication.network.retrofit

import android.util.Log
import com.example.user.myapplication.BuildConfig
import com.example.user.myapplication.network.okhttp.AuthenticationInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitCreator: IRetrofitCreator {
    val TAG = "LoginInteractor"
    override fun createIRetrofitApi(credentials: String): IRetrofitApi {
        Log.d(TAG, " getOrCreateAuthentication")
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.REST_URL)
                .client(createOkHttpClient(credentials))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()

        return retrofit.create(IRetrofitApi::class.java)
    }

    private fun createOkHttpClient(credentials: String): OkHttpClient {
        Log.d(TAG, "createOkHttpClient: ");
            return OkHttpClient().newBuilder()
                    .addInterceptor(AuthenticationInterceptor(credentials, ""))
                    .addInterceptor(createLoggingInterceptor())
                    .build()
        }

    private fun createLoggingInterceptor() : HttpLoggingInterceptor {
        Log.d(TAG, "createLoggingInterceptor: ");
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }



}