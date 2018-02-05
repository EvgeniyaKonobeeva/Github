package com.example.user.myapplication

import android.app.Application
import com.example.user.myapplication.di.app_di.DI

/**
 * Created by Evgeniya on 05.02.2018.
 */
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        DI.init(applicationContext)
    }
}