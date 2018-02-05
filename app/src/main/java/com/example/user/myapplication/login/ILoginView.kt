package com.example.user.myapplication.login

import com.arellomobile.mvp.MvpView

/**
 * Created by Evgeniya on 05.02.2018.
 */
interface ILoginView: MvpView{
    fun showLoginModel(loginModel: LoginModel)
}