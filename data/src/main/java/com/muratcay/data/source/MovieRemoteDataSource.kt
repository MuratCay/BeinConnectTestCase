package com.muratcay.data.source

import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.MovieResponse
import com.muratcay.data.repository.MovieDataSource
import com.muratcay.data.repository.MovieRemote
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieRemote: MovieRemote
) : MovieDataSource {

    override suspend fun getMovies(
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
    ): MovieResponse {
        return movieRemote.getMovies(api, language, sort, page, withGenres, withoutGenres, originalLanguage, notOriginalLanguage, releaseDateLte, releaseDateGte, voteAverageGte)
    }

    override suspend fun getGenres(api: String, language: String): Genre {
        return movieRemote.getGenres(api, language)
    }

    override suspend fun searchMovies(
        api: String,
        language: String,
        page: Int,
        query: String
    ): MovieResponse {
        return movieRemote.searchMovies(api, language, page, query)
    }
}