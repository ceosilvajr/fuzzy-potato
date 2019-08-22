package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.models.Movie
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_master_detail.*

/**
 * @author ceosilvajr@gmail.com
 */
class MasterDetailFragment : BaseFragment() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getSerializable(MOVIE) as Movie
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!::movie.isInitialized) throw RuntimeException("Required data not initialized.")
        return inflater.inflate(R.layout.fragment_master_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_name.text = movie.name
        tv_description.text = movie.description
        tv_genre.text = movie.genre
        tv_price.text = movie.price.toString()
        tv_preview_url.text = movie.previewUrl
        tv_artwork.text = movie.artwork
    }

    companion object {
        private const val MOVIE: String = "MOVIE"
        fun initWithBundle(movie: Movie): Bundle {
            val bundle = Bundle()
            bundle.putSerializable(MOVIE, movie)
            return bundle
        }
    }

}
