package com.example.prographyimagesearchapp.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ImageUsecases
import com.example.domain.usecase.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    imageUsecases: ImageUsecases,
) : ViewModel() {
    val imageUsecases = imageUsecases
    var _imageDetailFlow: MutableSharedFlow<ImageModel> = MutableSharedFlow()
    val imageDetailFlow = _imageDetailFlow
    fun getImageDetail(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            imageUsecases.getImageDetailUsecase(id)?.let { _imageDetailFlow.emit(it) }
        }
    }
    fun saveImage(image: ImageModel) {
        CoroutineScope(Dispatchers.IO).launch {
            imageUsecases.saveImageUseCase(image)
        }
    }
}