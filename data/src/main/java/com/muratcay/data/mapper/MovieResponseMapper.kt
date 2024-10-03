package com.muratcay.data.mapper

import javax.inject.Inject
import com.muratcay.data.models.MovieResponse

class MovieResponseMapper @Inject constructor(
    private val movieMapper: MovieMapper
): Mapper<MovieResponse, com.muratcay.domain.models.MovieResponse> {
    override fun mapToModel(type: MovieResponse): com.muratcay.domain.models.MovieResponse {
        return com.muratcay.domain.models.MovieResponse(
            page = type.page,
            movies = type.movies?.map { it?.let { movie -> movieMapper.mapToModel(movie) } },
            totalPages = type.totalPages,
            totalResults = type.totalResults
        )
    }
}