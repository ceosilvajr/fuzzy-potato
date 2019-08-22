package com.ceosilvajr.network.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceosilvajr.models.Movie
import com.ceosilvajr.network.repository.MovieRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

/**
 * @author ceosilvajr@gmail.com
 */
class OnlineMovieViewModel(private val repositoryImpl: MovieRepositoryImpl) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val onlineMovieLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun requestNewMovies() {
        repositoryImpl.getMovies().observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onlineMovieLiveData.value = it
                }, {
                    onlineMovieLiveData.value = arrayListOf()
                }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}