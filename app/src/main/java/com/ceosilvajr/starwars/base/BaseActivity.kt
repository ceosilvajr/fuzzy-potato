package com.ceosilvajr.starwars.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject

/**
 * @author ceosilvajr@gmail.com
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable by inject()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}