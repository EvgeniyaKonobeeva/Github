package com.example.user.myapplication.repositories

import com.example.user.myapplication.network.retrofit.ResponseTokenModel
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Evgeniya on 05.02.2018.
 */
interface ILoginRepository {
    fun getOrCreateAuthentication(credential: String): Observable<ResponseTokenModel>
}