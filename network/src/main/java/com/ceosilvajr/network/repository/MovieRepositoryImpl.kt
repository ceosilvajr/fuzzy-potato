package com.ceosilvajr.network.repository

import com.ceosilvajr.models.Movie
import com.ceosilvajr.network.ApiEndpoint
import io.reactivex.Flowable

/**
 * @author ceosilvajr@gmail.com
 */
class MovieRepositoryImpl(private val api: ApiEndpoint) : MovieRepository {

    override fun getMovies(): Flowable<List<Movie>> {
        val query = HashMap<String, Any>()
        query["term"] = "star wars"
        query["country"] = "au"
        query["media"] = "movie"
        return api.getMoviesByQuery(query).map {
            it.results?.map { data -> data.toModel() }?.toList()
        }
    }
}