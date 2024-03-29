package com.example.sampleapp.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.domain.common.asStatusLiveData
import com.example.sampleapp.domain.details.UserDetailsRepository
import com.example.sampleapp.presentation.common.SingleEventLiveData
import kotlin.properties.Delegates

class UserDetailsViewModel(private val repository: UserDetailsRepository) : ViewModel() {

    private var userId by Delegates.notNull<Int>()
    private val dataRefreshTrigger = SingleEventLiveData<Unit>()

    val data by lazy {
        dataRefreshTrigger.switchMap {
            repository.getUserDetails(userId)
                .asStatusLiveData(viewModelScope.coroutineContext)
        }
    }

    val avatarUrl by lazy {
        data.map { it.data?.avatarUrl }
    }

    val userName by lazy {
        data.map { it.data?.name }
    }

    val userLocation by lazy {
        data.map { it.data?.location }
    }

    val followers by lazy {
        data.map { it.data?.followersCount.toString() }
    }

    fun onViewCreated(id: Int) {
        userId = id
        dataRefreshTrigger.postValue(Unit)
    }

    fun onRetryClicked() {
        dataRefreshTrigger.postValue(Unit)
    }
}


