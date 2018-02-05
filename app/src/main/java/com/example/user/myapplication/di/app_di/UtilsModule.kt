package com.example.user.myapplication.di.app_di


import com.example.user.myapplication.utils.RxSchedulers
import com.example.user.myapplication.utils.RxSchedulersAbs
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Provides
    @Singleton
    internal fun provideRxSchedulersAbs(): RxSchedulersAbs {
        return RxSchedulers()
    }
}
