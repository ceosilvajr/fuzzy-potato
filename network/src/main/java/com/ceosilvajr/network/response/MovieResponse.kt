package com.ceosilvajr.network.response

import com.ceosilvajr.models.Movie
import com.google.gson.annotations.SerializedName

/**
 * @author ceosilvajr@gmail.com
 */
class MovieResponse {

    var resultCount: Int? = null
    var results: ArrayList<Data>? = null

    class Data {
        @SerializedName("trackName")
        var name: String? = null
        @SerializedName("artworkUrl100")
        var artwork: String? = null
        @SerializedName("trackPrice")
        var price: Double? = null
        @SerializedName("primaryGenreName")
        var genre: String? = null
        @SerializedName("longDescription")
        var description: String? = null
        @SerializedName("previewUrl")
        var previewUrl: String? = null

        fun toModel(): Movie {
            return Movie(name ?: "-", artwork ?: "-", price ?: 0.0,
                    genre ?: "-", description ?: "-", previewUrl ?: "-")
        }
    }

}