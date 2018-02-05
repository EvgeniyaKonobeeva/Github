package com.example.user.myapplication.di.app_di


import com.example.user.myapplication.di.login.LoginComponent
import com.example.user.myapplication.di.login.LoginModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class,
                             RepositoryModule::class,
                             NetWorkModule::class,
                             UtilsModule::class
                             ))
@Singleton
interface AppComponent {

    fun plus(loginModule: LoginModule): LoginComponent
}
