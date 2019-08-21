package com.ceosilvajr.starwars.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceosilvajr.network.repository.MovieRepositoryImpl
import com.ceosilvajr.starwars.R
import com.ceosilvajr.starwars.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

/**
 * @author ceosilvajr@gmail.com
 */
class HomeFragment : BaseFragment() {

    private val repository: MovieRepositoryImpl by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_view.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_masterDetailFragment)
        }
        repository.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    return@map it
                }
                .subscribe()
                .addTo(compositeDisposable)
    }
}
