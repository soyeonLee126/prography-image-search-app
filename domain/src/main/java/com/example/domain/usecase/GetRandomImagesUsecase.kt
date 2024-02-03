package com.example.domain.usecase

import com.example.domain.repository.UnsplashImageRepository

class GetRandomImagesUsecase (private val unsplashImageRepository: UnsplashImageRepository) {
    operator fun invoke() = unsplashImageRepository.getRandomImage()

}