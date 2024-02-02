package com.example.data.repository.datasource

import com.example.domain.usecase.model.UnSplashImage
import retrofit2.Response

interface UnsplashRemoteDataSource {
    suspend fun getImageList(page: Int): Response<UnSplashImage>
}