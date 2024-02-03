package com.example.data.repository.datasourceImpl

import com.example.data.api.UnSplashApi
import com.example.data.model.UnsplashImage
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.util.Mapper.toDomain
import com.example.domain.usecase.model.ImageModel
import retrofit2.Response
import javax.inject.Inject

class UnsplashRemoteDataSourceImpl @Inject constructor(private val api: UnSplashApi) : UnsplashRemoteDataSource {
    override suspend fun getImageList(page: Int): Response<List<UnsplashImage>> {
        return api.getImageList(page, 10)
    }

    override suspend fun getImageDetail(id: String): Response<UnsplashImage> {
        return api.getImageDetail()
    }

    override suspend fun getRandomImage(): Response<List<UnsplashImage>> = api.getRandomImage()
}
