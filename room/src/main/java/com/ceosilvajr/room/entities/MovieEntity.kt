package com.ceosilvajr.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author ceosilvajr@gmail.com
 */
@Entity(tableName = "Movies")
data class MovieEntity(
        @PrimaryKey val name: String,
        var artwork: String = "",
        var price: Double = 0.0,
        var genre: String = "",
        var description: String = "",
        var previewUrl: String = ""
)