package com.example.user.myapplication.network.retrofit

/**
 * Created by Evgeniya on 04.02.2018.
 */
interface IRetrofitCreator {
    fun createIRetrofitApi(credentials: String): IRetrofitApi
}