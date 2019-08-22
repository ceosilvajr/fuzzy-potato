package com.ceosilvajr.room.repository

import com.ceosilvajr.models.Movie
import com.ceosilvajr.room.dao.MovieDao
import com.ceosilvajr.room.entities.MovieEntity
import io.reactivex.Completable

/**
 * @author ceosilvajr@gmail.com
 */
class LocalMovieRepository(private val dao: MovieDao) {

    fun getAllMovies() = dao.getAllMovies()

    fun insertMovies(movies: List<Movie>): Completable {
        val entities = movies.map {
            MovieEntity(it.name, it.artwork, it.price, it.genre, it.description, it.previewUrl)
        }
        return dao.insertMovies(entities)
    }

}