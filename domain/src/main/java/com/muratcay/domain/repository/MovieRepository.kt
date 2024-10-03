package com.muratcay.domain.repository

import com.muratcay.domain.Result
import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

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
    ): Flow<Result<MovieResponse>>

    suspend fun getGenres(
        api: String, language: String
    ): Flow<Result<Genre>>

    suspend fun searchMovies(
        api: String, language: String, page: Int, query: String
    ): Flow<Result<MovieResponse>>
}