package com.example.prographyimagesearchapp.di

import DeleteSavedImageUsecase
import GetImageListUsecase
import GetSavedImageListUsecase
import GetSavedImageUsecase
import SaveImageUsecase
import com.example.domain.repository.UnsplashImageRepository
import com.example.domain.usecase.GetImageDetailUsecase
import com.example.domain.usecase.GetRandomImagesUsecase
import com.example.domain.usecase.ImageUsecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideImageUseCases(imageRepository: UnsplashImageRepository) = ImageUsecases(
        getImageDetailUsecase = GetImageDetailUsecase(imageRepository),
        getImageListUseCase = GetImageListUsecase(imageRepository),
        getSavedImageListUsecase = GetSavedImageListUsecase(imageRepository),
        getRandomImagesUsecase = GetRandomImagesUsecase(imageRepository),
        deleteSavedImageUseCase = DeleteSavedImageUsecase(imageRepository),
        saveImageUseCase = SaveImageUsecase(imageRepository),
        getSavedImage = GetSavedImageUsecase(imageRepository)
    )
}