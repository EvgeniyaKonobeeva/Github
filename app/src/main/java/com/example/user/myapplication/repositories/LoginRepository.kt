package com.example.user.myapplication.repositories

import android.util.Log
import com.example.user.myapplication.network.retrofit.IRetrofitCreator
import com.example.user.myapplication.network.retrofit.RequestAuthModel
import com.example.user.myapplication.network.retrofit.ResponseTokenModel
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Evgeniya on 05.02.2018.
 */
class LoginRepository(val retrofitCreator: IRetrofitCreator, val modelBody: RequestAuthModel) : ILoginRepository {
    val TAG = "LoginRepository"
    override fun getOrCreateAuthentication(credential: String): Observable<ResponseTokenModel> {
        Log.d(TAG, " getOrCreateAuthentication")
        return retrofitCreator.createIRetrofitApi(credential).getToken(modelBody)
    }
}