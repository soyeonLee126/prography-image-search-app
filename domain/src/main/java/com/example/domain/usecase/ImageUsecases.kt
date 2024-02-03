package com.example.domain.usecase

import DeleteSavedImageUsecase
import GetImageListUsecase
import GetSavedImageListUsecase
import GetSavedImageUsecase
import SaveImageUsecase

data class ImageUsecases (
    val getImageListUseCase: GetImageListUsecase,
    val getImageDetailUsecase: GetImageDetailUsecase,
    val getRandomImagesUsecase: GetRandomImagesUsecase,
    val getSavedImageListUsecase: GetSavedImageListUsecase,
    val getSavedImage: GetSavedImageUsecase,
    val saveImageUseCase: SaveImageUsecase,
    val deleteSavedImageUseCase: DeleteSavedImageUsecase,
)