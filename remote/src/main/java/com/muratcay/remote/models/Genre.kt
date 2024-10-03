package com.muratcay.remote.models

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genres")
    val genres: List<GenreX>?
)