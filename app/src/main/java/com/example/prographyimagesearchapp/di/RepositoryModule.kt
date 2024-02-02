package com.example.prographyimagesearchapp.di

import com.example.data.db.UnSplashImageDAO
import com.example.data.repository.UnsplashImageRepositoryImpl
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.domain.repository.UnsplashImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideImageRepository(
        remoteDataSource: UnsplashRemoteDataSource,
        localDataSource: UnSplashImageDAO
    ): UnsplashImageRepository =
        UnsplashImageRepositoryImpl(remoteDataSource, localDataSource)
}