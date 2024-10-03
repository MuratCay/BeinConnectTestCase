package com.muratcay.beinconnecttestcase.di

import com.muratcay.data.MovieRepositoryImpl
import com.muratcay.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository =
        movieRepository
}