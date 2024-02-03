package com.example.prographyimagesearchapp.ui.randomphoto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ImageUsecases
import com.example.domain.usecase.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    imageUsecases: ImageUsecases,
) : ViewModel() {
    val usecases = imageUsecases
    var _imageFlow: MutableSharedFlow<ImageModel> = MutableSharedFlow()
    val imageFlow = _imageFlow
    fun getRandomImage() {
        CoroutineScope(Dispatchers.IO).launch {
            usecases.getRandomImagesUsecase()?.let { _imageFlow.emit(it) }
        }
    }
}