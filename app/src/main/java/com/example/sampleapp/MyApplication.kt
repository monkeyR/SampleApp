package com.example.sampleapp

import android.app.Application
import androidx.multidex.MultiDex
import com.example.sampleapp.di.ApplicationModule
import com.example.sampleapp.di.NetworkModule
import com.example.sampleapp.di.UserDetailsModule
import com.example.sampleapp.di.UserListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    ApplicationModule,
                    UserDetailsModule,
                    NetworkModule,
                    UserListModule
                )
            )
        }
    }
}