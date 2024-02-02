package com.example.data.repository.datasourceImpl

import com.example.data.api.UnSplashApi
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.domain.usecase.model.UnSplashImage
import retrofit2.Response
import javax.inject.Inject

class UnsplashRemoteDataSourceImpl @Inject constructor(private val api: UnSplashApi) : UnsplashRemoteDataSource {
    override suspend fun getImageList(): Response<UnSplashImage> {
        return api.getImageList(1, "10")
    }
}
