package com.example.user.myapplication.interactors

import android.util.Log
import com.example.user.myapplication.login.LoginModel
import com.example.user.myapplication.repositories.ILoginRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.Credentials
import retrofit2.HttpException

/**
 * Created by Evgeniya on 05.02.2018.
 */
class LoginInteractor(var loginRepository: ILoginRepository): ILoginInteractor  {
    val TAG = "LoginInteractor"
     override fun getOrCreateAuthentication(userName: String, password: String)  : Observable<LoginModel> {
         Log.d(TAG, " getOrCreateAuthentication")
         return loginRepository.getOrCreateAuthentication(Credentials.basic(userName, password))
                 .map { responseTokenModel ->
                     LoginModel(
                             false, false,
                             false, "",
                             true, false)
                 }
                 .startWith(
                         {
                             LoginModel(
                                     false, false,
                                     false, "",
                                     false, true)
                         })
                 .onErrorReturn { throwable: Throwable ->
                     kotlin.run {
                         when (throwable) {
                             is HttpException ->
                                 LoginModel(
                                         false, false,
                                         true, throwable.message(),
                                         false, false)
                             else ->
                                 LoginModel(
                                         false, true,
                                         false, throwable.message ?: "",
                                         false, false)


                         }
                     }


                 }
     }

}