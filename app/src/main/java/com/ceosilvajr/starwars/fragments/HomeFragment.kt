package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.ceosilvajr.models.Movie
import com.ceosilvajr.room.viewmodel.LocalMovieViewModel
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.adapter.MovieListAdapter
import com.ceosilvajr.starwars.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * @author ceosilvajr@gmail.com
 */
class HomeFragment : BaseFragment(), MovieListAdapter.Listener {

    private val localMovieViewModel: LocalMovieViewModel by sharedViewModel()
    private val movieListAdapter: MovieListAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        localMovieViewModel.observeLocalMovie(activity!!) { updateView(it) }
    }

    private fun setupView() {
        movieListAdapter.init(context!!, this)
        rv_movies.setHasFixedSize(true)
        rv_movies.adapter = movieListAdapter
    }

    private fun updateView(it: List<Movie>) {
        val mainMovie = it.random()
        iv_blur_banner.load(mainMovie.artwork)
        iv_banner.load(mainMovie.artwork) {
            crossfade(true)
            placeholder(R.drawable.img_movie_placeholder)
        }
        tv_name.text = mainMovie.name
        iv_info.setOnClickListener { onMovieItemClicked(mainMovie) }
        movieListAdapter.updateList(it as ArrayList<Movie>)
    }

    override fun onMovieItemClicked(movie: Movie) {
        navController.navigate(R.id.action_homeFragment_to_masterDetailFragment,
                MasterDetailFragment.initWithBundle(movie))
    }
}