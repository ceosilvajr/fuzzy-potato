package com.ceosilvajr.network

import com.ceosilvajr.network.response.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author ceosilvajr@gmail.com
 */
interface ApiEndpoint {
    @GET("search")
    fun getMoviesByQuery(@QueryMap query: HashMap<String, Any>): Flowable<MovieResponse>
}