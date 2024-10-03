package com.muratcay.data.repository

import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.MovieResponse

interface MovieRemote {

    suspend fun getMovies(
        api: String,
        language: String,
        sort: String,
        page: Int,
        withGenres: String,
        withoutGenres: String,
        originalLanguage: String,
        notOriginalLanguage: String,
        releaseDateLte: String,
        releaseDateGte: String,
        voteAverageGte: String
    ): MovieResponse

    suspend fun getGenres(
        api: String, language: String
    ): Genre

    suspend fun searchMovies(
        api: String, language: String, page: Int, query: String
    ): MovieResponse

}