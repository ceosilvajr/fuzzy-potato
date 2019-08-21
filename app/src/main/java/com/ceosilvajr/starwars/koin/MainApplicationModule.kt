package com.ceosilvajr.starwars.koin

import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * @author ceosilvjr@gmail.com
 */
object MainApplicationModule {

    fun load() = module {
        factory { CompositeDisposable() }
    }
}