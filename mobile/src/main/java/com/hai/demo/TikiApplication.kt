package com.hai.demo

import android.app.Application
import com.hai.demo.di.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TikiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TikiApplication)
            modules(modules)
        }
    }
}