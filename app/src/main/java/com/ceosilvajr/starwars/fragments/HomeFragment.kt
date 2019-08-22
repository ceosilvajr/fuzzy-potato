package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.models.Movie
import com.ceosilvajr.room.viewmodel.LocalMovieViewModel
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * @author ceosilvajr@gmail.com
 */
class HomeFragment : BaseFragment() {

    private lateinit var movies: List<Movie>

    private val localMovieViewModel: LocalMovieViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_view.setOnClickListener {
            if (::movies.isInitialized) {
                navController.navigate(R.id.action_homeFragment_to_masterDetailFragment,
                        MasterDetailFragment.initWithBundle(movies[0]))
            }
        }
        localMovieViewModel.observeLocalMovie(activity!!) {
            this.movies = it
        }
    }

}