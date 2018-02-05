package com.example.user.myapplication.interactors

import com.example.user.myapplication.login.LoginModel
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Evgeniya on 05.02.2018.
 */
interface ILoginInteractor {
   fun getOrCreateAuthentication(userName:String, password:String): Observable<LoginModel>
}