package com.example.prographyimagesearchapp.ui.home


import androidx.lifecycle.ViewModel
import com.example.domain.usecase.ImageUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    imageUsecases: ImageUsecases,
) : ViewModel() {
    val getImageListUseCase = imageUsecases.getImageListUseCase()
    val bookmarkedListUseCase = imageUsecases.getSavedImageListUsecase()
}