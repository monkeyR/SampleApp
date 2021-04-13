package com.example.sampleapp.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.domain.asStatusLiveData
import com.example.sampleapp.domain.userlist.UserListRepository
import com.example.sampleapp.presentation.utils.SingleEventLiveData

class UserListViewModel(private val repository: UserListRepository) : ViewModel() {

    private val dataRefreshTrigger = SingleEventLiveData<Unit>()

    val data by lazy {
        dataRefreshTrigger.switchMap {
            repository.getUsers().asStatusLiveData(viewModelScope.coroutineContext, 5000L)
        }
    }

    fun onViewCreated() {
        dataRefreshTrigger.postValue(Unit)
    }

    fun onRetryClicked() {
        dataRefreshTrigger.postValue(Unit)
    }
}