package com.example.prographyimagesearchapp.di

import com.example.data.api.UnSplashApi
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.repository.datasourceImpl.UnsplashRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    @Singleton
    fun provideImageRemoteDataSource(unsplashApi: UnSplashApi) : UnsplashRemoteDataSource = UnsplashRemoteDataSourceImpl(unsplashApi)
}