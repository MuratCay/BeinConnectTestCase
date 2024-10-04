package com.muratcay.domain.usecase

import com.muratcay.domain.models.GetMoviesParams
import com.muratcay.domain.models.MovieResponse
import com.muratcay.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetMoviesBaseUseCase = BaseUseCase<GetMoviesParams, Flow<com.muratcay.domain.Result<MovieResponse>>>

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) : GetMoviesBaseUseCase {

    override suspend fun invoke(params: GetMoviesParams): Flow<com.muratcay.domain.Result<MovieResponse>> {
        return repository.getMovies(
            api = params.api,
            language = params.language,
            sort = params.sort,
            page = params.page,
            withGenres = params.withGenres,
            withoutGenres = params.withoutGenres,
            originalLanguage = params.originalLanguage,
            notOriginalLanguage = params.notOriginalLanguage,
            releaseDateLte = params.releaseDateLte,
            releaseDateGte = params.releaseDateGte,
            voteAverageGte = params.voteAverageGte
        )
    }
}