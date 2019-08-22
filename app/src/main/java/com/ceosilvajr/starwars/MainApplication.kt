package com.ceosilvajr.starwars

import android.app.Application
import com.ceosilvajr.network.NetworkModule
import com.ceosilvajr.room.RoomModule
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
            modules(arrayListOf(
                    MainApplicationModule.load(),
                    NetworkModule.load(),
                    RoomModule.load(this@MainApplication
                    ))
            )
        }
    }
}

