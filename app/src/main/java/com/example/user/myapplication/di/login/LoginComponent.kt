package com.example.user.myapplication.di.login

import com.example.user.myapplication.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by Evgeniya on 05.02.2018.
 */
@Subcomponent(modules = arrayOf(LoginModule::class))
@LoginScope
interface LoginComponent {
    fun inject(actirivty: LoginActivity)
}