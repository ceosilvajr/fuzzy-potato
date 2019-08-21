package com.ceosilvajr.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceosilvajr.room.entities.MovieEntity
import io.reactivex.Completable

/**
 * @author ceosilvajr@gmail.com
 */
@Dao
interface MovieDao {

    @Query("SELECT * from Movies ORDER BY name ASC")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(entities: List<MovieEntity>): Completable

    @Query("DELETE FROM Movies")
    fun deleteAll(): Completable

}