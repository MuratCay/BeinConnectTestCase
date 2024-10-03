package com.muratcay.data

import com.muratcay.data.mapper.MovieResponseMapper
import com.muratcay.data.source.MovieDataSourceFactory
import com.muratcay.domain.Result
import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.MovieResponse
import com.muratcay.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSourceFactory: MovieDataSourceFactory,
    private val movieResponseMapper: MovieResponseMapper
): MovieRepository {

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
    ): Flow<Result<MovieResponse>> = flow {
        val response = movieDataSourceFactory.getRemoteDataSource().getMovies(
            api, language, sort,
            page, withGenres,withoutGenres, originalLanguage,
            notOriginalLanguage, releaseDateLte, releaseDateGte,
            voteAverageGte
        )
        emit(Result.Success(response))
    }

    override suspend fun getGenres(api: String, language: String): Flow<Result<Genre>> = flow {
        val response = movieDataSourceFactory.getRemoteDataSource().getGenres(api, language)
        emit(Result.Success(response))
    }

    override suspend fun searchMovies(
        api: String,
        language: String,
        page: Int,
        query: String
    ): Flow<Result<MovieResponse>> = flow {
        val response = movieDataSourceFactory.getRemoteDataSource().searchMovies(api, language, page, query)
        emit(Result.Success(response))
    }

}