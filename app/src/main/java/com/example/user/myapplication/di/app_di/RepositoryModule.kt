package com.example.user.myapplication.di.app_di

import com.example.user.myapplication.BuildConfig
import com.example.user.myapplication.network.retrofit.IRetrofitCreator
import com.example.user.myapplication.network.retrofit.RequestAuthModel
import com.example.user.myapplication.repositories.ILoginRepository
import com.example.user.myapplication.repositories.LoginRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Evgeniya on 05.02.2018.
 */
@Module
class RepositoryModule {
    @Provides
    fun provideILoginRepository(retrofitCreator: IRetrofitCreator, modelBody: RequestAuthModel): ILoginRepository=
            LoginRepository(retrofitCreator, modelBody)

    @Provides
    fun provideRequestAuthModel(): RequestAuthModel =
        RequestAuthModel().apply {
            clientId = BuildConfig.GITHUB_CLIENT_ID
            clientSecret = BuildConfig.GITHUB_SECRET
            scopes = (listOf<String>("read:user"))
            note = BuildConfig.APPLICATION_ID
        }
}