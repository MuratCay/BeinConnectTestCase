package com.muratcay.beinconnecttestcase.di

import com.muratcay.data.repository.MovieRemote
import com.muratcay.remote.repository.MovieRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideMovieRemote(movieRemoteImpl: MovieRemoteImpl): MovieRemote = movieRemoteImpl
}