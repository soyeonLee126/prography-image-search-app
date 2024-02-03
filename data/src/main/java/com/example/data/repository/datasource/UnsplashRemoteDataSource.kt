package com.example.data.repository.datasource

import com.example.data.model.UnsplashImage
import com.example.domain.usecase.model.ImageModel
import retrofit2.Response

interface UnsplashRemoteDataSource {
    suspend fun getImageList(page: Int): Response<List<UnsplashImage>>
    suspend fun getImageDetail(id: String): Response<UnsplashImage>
    suspend fun getRandomImage(): Response<List<UnsplashImage>>
}