package com.muratcay.domain.models

data class GetMoviesParams(
    val api: String,
    val language: String,
    val sort: String,
    val page: Int,
    val withGenres: String,
    val withoutGenres: String,
    val originalLanguage: String,
    val notOriginalLanguage: String,
    val releaseDateLte: String,
    val releaseDateGte: String,
    val voteAverageGte: String
)