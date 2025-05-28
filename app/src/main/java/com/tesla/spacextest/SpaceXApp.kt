package com.tesla.spacextest

import android.app.Application
import com.tesla.spacextest.di.appModule
import com.tesla.spacextest.di.dispatchersModule
import com.tesla.spacextest.di.networkModule
import com.tesla.spacextest.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SpaceXApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@SpaceXApp)
            modules(appModule, networkModule, repositoryModule, dispatchersModule)
        }
    }
}