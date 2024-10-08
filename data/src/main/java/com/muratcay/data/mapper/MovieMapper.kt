package com.muratcay.data.mapper

import com.muratcay.data.models.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<Movie, com.muratcay.domain.models.Movie> {
    override fun mapToModel(type: Movie): com.muratcay.domain.models.Movie {
        return com.muratcay.domain.models.Movie(
            adult = type.adult,
            backdropPath = type.backdropPath,
            genreIds = type.genreIds,
            id = type.id,
            originalLanguage = type.originalLanguage,
            originalTitle = type.originalTitle,
            overview = type.overview,
            popularity = type.popularity,
            posterPath = type.posterPath,
            releaseDate = type.releaseDate,
            title = type.title,
            video = type.video,
            voteAverage = type.voteAverage,
            voteCount = type.voteCount,
            image = type.image
        )
    }
}