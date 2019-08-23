package com.ceosilvajr.network.repository

import com.ceosilvajr.models.Movie
import io.reactivex.Flowable

/**
 * @author ceosilvajr@gmail.com
 */
interface MovieRepository {
    fun getMovies(): Flowable<List<Movie>>
}