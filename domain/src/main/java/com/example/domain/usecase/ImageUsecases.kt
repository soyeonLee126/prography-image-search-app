package com.example.domain.usecase

import DeleteSavedImageUsecase
import GetImageListUsecase
import GetSavedImgaeListUsecase
import SaveImageUsecase

data class ImageUsecases (
    val getImageListUseCase: GetImageListUsecase,
    val getImageDetailUsecase: GetImageDetailUsecase,
    val getRandomImagesUsecase: GetRandomImagesUsecase,
    val getSavedImageListUsecase: GetSavedImgaeListUsecase,
    val saveImageUseCase: SaveImageUsecase,
    val deleteSavedImageUseCase: DeleteSavedImageUsecase,
)