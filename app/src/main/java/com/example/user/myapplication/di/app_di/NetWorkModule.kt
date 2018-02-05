package com.example.user.myapplication.di.app_di

import com.example.user.myapplication.network.retrofit.IRetrofitCreator
import com.example.user.myapplication.network.retrofit.RetrofitCreator
import dagger.Module
import dagger.Provides

/**
 * Created by Evgeniya on 05.02.2018.
 */
@Module
class NetWorkModule {
    @Provides
    fun provideIRetrofitCreator(): IRetrofitCreator = RetrofitCreator()

}