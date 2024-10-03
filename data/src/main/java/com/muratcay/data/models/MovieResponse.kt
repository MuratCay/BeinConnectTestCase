package com.muratcay.data.models

data class MovieResponse(
    val page: Int?, val movies: List<Movie?>?, val totalPages: Int?, val totalResults: Int?
)