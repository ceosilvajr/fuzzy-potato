package com.ceosilvajr.room

import android.content.Context
import com.ceosilvajr.room.repository.LocalMovieRepository
import com.ceosilvajr.room.viewmodel.LocalMovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author ceosilvajr@gmail.com
 */
object RoomModule {

    fun load(context: Context) = module {
        single { MainDatabase.getInstance(context) }
        single { get<MainDatabase>().movieDao() }
        factory { LocalMovieRepository(get()) }
        viewModel { LocalMovieViewModel(get()) }
    }
}