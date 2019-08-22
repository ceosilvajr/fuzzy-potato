package com.ceosilvajr.starwars

import com.ceosilvajr.starwars.adapter.MovieListAdapter
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * @author ceosilvjr@gmail.com
 */
object MainApplicationModule {

    fun load() = module {
        factory { CompositeDisposable() }
        factory { MovieListAdapter(arrayListOf()) }
    }
}