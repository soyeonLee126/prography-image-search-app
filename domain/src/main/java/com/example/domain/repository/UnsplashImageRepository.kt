package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.usecase.model.UnSplashImage
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {
    fun getImageList(): Flow<PagingData<UnSplashImage>>
    fun getSavedImageList(): Flow<PagingData<UnSplashImage>>
    fun getImageDetail(): UnSplashImage
    fun getRandomImage(): UnSplashImage
    suspend fun saveImage(image: UnSplashImage)
    suspend fun deleteSavedImage(image: UnSplashImage)
}