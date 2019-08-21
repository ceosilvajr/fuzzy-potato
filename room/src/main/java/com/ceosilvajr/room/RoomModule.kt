package com.ceosilvajr.room

import android.content.Context
import org.koin.dsl.module

/**
 * @author ceosilvajr@gmail.com
 */
object RoomModule {

    fun load(context: Context) = module {
        single { MainDatabase.getInstance(context) }
    }
}