package com.muratcay.remote.service

import com.muratcay.data.models.MovieResponse
import com.muratcay.data.models.Genre
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("sort_by") sort: String,
        @Query("page") page: Int,
        @Query("with_genres") withGenres: String,
        @Query("without_genres") withoutGenres: String,
        @Query("with_original_language") originalLanguage: String,
        @Query("without_original_language") notOriginalLanguage: String,
        @Query("release_date.lte") releaseDateLte: String,
        @Query("release_date.gte") releaseDateGte: String,
        @Query("vote_average.gte") voteAverageGte: String
    ): MovieResponse

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") api: String,
        @Query("language") language: String
    ): Genre

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") api: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): MovieResponse
}