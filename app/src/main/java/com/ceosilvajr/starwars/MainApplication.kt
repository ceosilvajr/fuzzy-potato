package com.ceosilvajr.starwars

import android.app.Application
import com.ceosilvajr.starwars.koin.MainApplicationModule
import com.ceosilvajr.starwars.koin.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author ceosilvajr@gmail.com
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(arrayListOf(MainApplicationModule.load(), NetworkModule.load()))
        }
    }
}