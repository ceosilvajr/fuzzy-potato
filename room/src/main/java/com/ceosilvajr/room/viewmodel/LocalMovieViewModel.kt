package com.ceosilvajr.room.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ceosilvajr.models.Movie
import com.ceosilvajr.room.entities.MovieEntity
import com.ceosilvajr.room.repository.LocalMovieRepository

/**
 * @author ceosilvajr@gmail.com
 */
class LocalMovieViewModel(private val repository: LocalMovieRepository) : ViewModel() {

    private val allLocalMovies: LiveData<List<MovieEntity>> = repository.getAllMovies()

    fun observeLocalMovie(owner: LifecycleOwner, onReady: (result: List<Movie>) -> Unit) {
        allLocalMovies.observe(owner, Observer {
            onReady.invoke(it.map { Movie(it.name, it.artwork, it.price, it.genre, it.description, it.previewUrl) })
        })
    }

    fun insertMovies(movies: List<Movie>) = repository.insertMovies(movies)
}