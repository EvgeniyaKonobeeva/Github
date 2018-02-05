package com.example.user.myapplication.di.app_di


import android.content.Context


class ComponentManager(context: Context) {

    private val mAppComponent: AppComponent


    init {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(context))
                .utilsModule(UtilsModule())
                .repositoryModule(RepositoryModule())
                .netWorkModule(NetWorkModule())
                .build()


    }


    fun appComponent(): AppComponent {
        return mAppComponent

    }


}
