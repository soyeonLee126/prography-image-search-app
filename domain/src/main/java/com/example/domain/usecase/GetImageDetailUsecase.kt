package com.example.domain.usecase

import com.example.domain.repository.UnsplashImageRepository

class GetImageDetailUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    suspend operator fun invoke() = unsplashImageRepository.getImageDetail()

}