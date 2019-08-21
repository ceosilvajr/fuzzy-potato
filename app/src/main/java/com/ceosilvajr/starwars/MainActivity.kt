package com.ceosilvajr.starwars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author ceosilvajr@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
    }

}
