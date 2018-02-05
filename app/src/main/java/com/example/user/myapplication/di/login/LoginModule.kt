package com.example.user.myapplication.di.login

import com.example.user.myapplication.interactors.ILoginInteractor
import com.example.user.myapplication.interactors.LoginInteractor
import com.example.user.myapplication.login.LoginPresenter
import com.example.user.myapplication.repositories.ILoginRepository
import com.example.user.myapplication.utils.RxSchedulersAbs
import dagger.Module
import dagger.Provides

/**
 * Created by Evgeniya on 05.02.2018.
 */
@Module
class LoginModule {
    @Provides
    fun provideLoginPresenter(oginInteractor: ILoginInteractor) : LoginPresenter
            = LoginPresenter(oginInteractor)

    @Provides
    @LoginScope
    fun provideLoginInteractor(loginRepository: ILoginRepository): ILoginInteractor =
            LoginInteractor(loginRepository)
}