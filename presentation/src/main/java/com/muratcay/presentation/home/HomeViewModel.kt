package com.muratcay.presentation.home

import androidx.lifecycle.viewModelScope
import com.muratcay.domain.models.GetMoviesParams
import com.muratcay.domain.usecase.GetMoviesUseCase
import com.muratcay.presentation.base.BaseViewModel
import com.muratcay.presentation.models.categories
import com.muratcay.presentation.utils.Constants.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel<HomeState>() {

    override fun setInitialState(): HomeState = HomeState.Loading

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            categories.forEach { category ->
                getMoviesUseCase.invoke(
                    params = GetMoviesParams(
                        api = API_KEY,
                        language = category.originalLanguage,
                        sort = "popularity.desc",
                        page = 1,
                        withGenres = "",
                        withoutGenres = "",
                        originalLanguage = category.originalLanguage,
                        notOriginalLanguage = category.notOriginalLanguage,
                        releaseDateLte = category.releaseDateBefore,
                        releaseDateGte = category.releaseDateAfter,
                        voteAverageGte = category.minVoteAverage
                    )
                ).collect { result ->
                    when (result) {
                        is com.muratcay.domain.Result.Success -> {
                            setState(HomeState.BaseMoviesLoaded(result.data?.movies))
                            println(result.data?.movies)
                        }

                        is com.muratcay.domain.Result.Error -> {
                            setState(HomeState.Error(result.error))
                        }

                        is com.muratcay.domain.Result.Loading -> {
                            setState(HomeState.Loading)
                        }
                    }
                }
            }
        }
    }
}