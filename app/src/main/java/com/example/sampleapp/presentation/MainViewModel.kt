package com.example.sampleapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.domain.OpenApplicationRepository
import kotlinx.coroutines.flow.filter

class MainViewModel(
    private val repository: OpenApplicationRepository
) : ViewModel() {

    private val isFirstOpen by lazy {
        repository.checkIsFirstOpen()
    }

    val goToSplashScreen = isFirstOpen.filter { it }
        .asLiveData(viewModelScope.coroutineContext)

    val goToMainScreen = isFirstOpen.filter { !it }
        .asLiveData(viewModelScope.coroutineContext)
}