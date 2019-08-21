package com.ceosilvajr.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ceosilvajr.room.dao.MovieDao
import com.ceosilvajr.room.entities.MovieEntity

/**
 * @author ceosilvajr@gmail.com
 */
@Database(entities = [MovieEntity::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        MainDatabase::class.java, "movieApp.db").build()
    }
}