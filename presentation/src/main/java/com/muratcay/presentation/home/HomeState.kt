package com.muratcay.presentation.home

import com.muratcay.domain.models.Genre
import com.muratcay.domain.models.Movie
import com.muratcay.presentation.base.IState
import com.muratcay.presentation.utils.Resource

sealed interface HomeState : IState {
    data object Loading : HomeState
    data class GenresLoaded(val genres: List<Genre?>?) : HomeState
    data class BaseMoviesLoaded(val movies: List<Movie?>?) : HomeState
    data class CategoryMoviesLoaded(val categories: List<Resource<Any>>?) : HomeState
    data class Error(val error: Exception?) : HomeState
}