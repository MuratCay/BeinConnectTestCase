package com.muratcay.remote.repository

import com.muratcay.data.repository.MovieRemote
import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.GenreX
import com.muratcay.remote.mapper.MovieResponseMapper
import com.muratcay.remote.service.MovieService
import javax.inject.Inject

class MovieRemoteImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieResponseMapper: MovieResponseMapper
): MovieRemote {

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
    ): com.muratcay.domain.models.MovieResponse {
        val response = movieService.getMovies(
            api = api,
            language = language,
            sort = sort,
            page = page,
            withGenres = withGenres,
            withoutGenres = withoutGenres,
            originalLanguage = originalLanguage,
            notOriginalLanguage = notOriginalLanguage,
            releaseDateLte = releaseDateLte,
            releaseDateGte = releaseDateGte,
            voteAverageGte = voteAverageGte
        )

        return movieResponseMapper.mapToModel(response)
    }

    override suspend fun getGenres(
        api: String,
        language: String
    ): Genre {
        return Genre(genres = listOf( GenreX(id = 21, name = "Adventure")))
    }

    override suspend fun searchMovies(
        api: String,
        language: String,
        page: Int,
        query: String
    ): com.muratcay.domain.models.MovieResponse {
        val response = movieService.searchMovies(
            api = api,
            language = language,
            page = page,
            query = query
        )
        return movieResponseMapper.mapToModel(response)
    }
}