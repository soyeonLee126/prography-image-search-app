package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.usecase.model.ImageModel
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {
    fun getImageList(): Flow<PagingData<ImageModel>>
    fun getSavedImageList(): Flow<PagingData<ImageModel>>
    suspend fun getImageDetail(id: String): ImageModel?
    suspend fun getRandomImage(): List<ImageModel>
    suspend fun saveImage(image: ImageModel)
    suspend fun deleteSavedImage(image: ImageModel)
}