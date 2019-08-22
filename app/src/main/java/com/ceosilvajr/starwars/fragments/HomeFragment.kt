package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.models.Movie
import com.ceosilvajr.room.viewmodel.LocalMovieViewModel
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.info
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author ceosilvajr@gmail.com
 */
class HomeFragment : BaseFragment() {

    private val localMovieViewModel: LocalMovieViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_view.setOnClickListener {
            val movies = arrayListOf(
                    Movie("Movie 1"),
                    Movie("Movie 2"),
                    Movie("Movie 3")
            )

            localMovieViewModel.insertMovies(movies)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ info("Save completed.") }, { error(it) })
                    .addTo(compositeDisposable)

            // navController.navigate(R.id.action_homeFragment_to_masterDetailFragment)
        }

        localMovieViewModel.observeLocalMovie(this) {
            it.forEach { movie ->
                info(movie.toString())
            }
        }
    }
}
