package com.muratcay.data.source

import com.muratcay.data.repository.MovieDataSource
import javax.inject.Inject

class MovieDataSourceFactory @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
) {

    // Here, if there is data in the cache, it is retrieved from the cache, otherwise, data is retrieved from the API.

    fun getRemoteDataSource(): MovieDataSource {
        return movieRemoteDataSource
    }

}