package com.example.prographyimagesearchapp

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.ImageUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val usecases: ImageUsecases
) : ViewModel() {

}