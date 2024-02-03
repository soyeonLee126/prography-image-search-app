package com.example.prographyimagesearchapp.ui.randomphoto

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ImageUsecases
import com.example.domain.usecase.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomPhotoViewModel @Inject constructor(
    imageUsecases: ImageUsecases,
) : ViewModel() {
    val imageUsecases = imageUsecases
    val getRandomImage = imageUsecases.getRandomImagesUsecase()
    var _swipeFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val swipeFlow = _swipeFlow
    fun saveImage(image: ImageModel) =
        CoroutineScope(Dispatchers.IO).launch {
            imageUsecases.saveImageUseCase(image)
            _swipeFlow.emit(true)
        }
    fun swipe() {
        _swipeFlow.tryEmit(true)
    }
}