package com.muratcay.presentation.home

import com.muratcay.domain.models.Movie
import com.muratcay.presentation.base.IState

sealed interface HomeState : IState {
    data object Loading : HomeState
    data class Success(val data: List<Movie?>?) : HomeState
    data class Error(val error: Exception?) : HomeState
}