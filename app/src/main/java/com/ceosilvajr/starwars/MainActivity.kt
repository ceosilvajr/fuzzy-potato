package com.ceosilvajr.starwars

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.ceosilvajr.network.viewmodel.OnlineMovieViewModel
import com.ceosilvajr.room.viewmodel.LocalMovieViewModel
import com.ceosilvajr.starwars.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author ceosilvajr@gmail.com
 */
class MainActivity : BaseActivity() {

    private val onlineMovieViewModel: OnlineMovieViewModel by viewModel()
    private val localMovieViewModel: LocalMovieViewModel by viewModel()

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        setupNavigation()
        setupActionBar()
        initializeMovieData()
    }

    override fun onSupportNavigateUp() = navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    private fun setupActionBar() {
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupNavigation() {
        val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = host.navController
    }

    private fun initializeMovieData() {
        onlineMovieViewModel.onlineMovieLiveData.observe(this, Observer {
            localMovieViewModel.insertMovies(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe()
                    .addTo(compositeDisposable)
        })
        onlineMovieViewModel.requestNewMovies()
    }

}
