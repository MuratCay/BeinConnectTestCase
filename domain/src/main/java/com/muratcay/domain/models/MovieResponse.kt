package com.muratcay.domain.models

data class MovieResponse(
    val page: Int?, val movies: List<Movie?>?, val totalPages: Int?, val totalResults: Int?
)