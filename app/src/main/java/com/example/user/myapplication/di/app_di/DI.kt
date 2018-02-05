package com.example.user.myapplication.di.app_di

import android.content.Context

class DI private constructor(context: Context) {
    companion object {

        var instance: DI? = null
            private set


        fun init(context: Context) {
            instance = DI(context)
        }
    }


    fun componentManager(): ComponentManager {
        return componentManager
    }

    private val componentManager: ComponentManager = ComponentManager(context)





}
