package com.ceosilvajr.models

/**
 * @author ceosilvajr@gmail.com
 */
data class Movie(
        var name: String = "",
        var artwork: String = "",
        var price: Double = 0.0,
        var genre: String = "",
        var description: String = "",
        var previewUrl: String = ""
)