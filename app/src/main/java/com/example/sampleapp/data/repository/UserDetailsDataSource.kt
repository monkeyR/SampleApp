package com.example.sampleapp.data.repository

import com.example.sampleapp.data.api.UserDetailsApi
import com.example.sampleapp.data.mapper.UserDetailsMapper
import com.example.sampleapp.domain.details.UserDetailsRepository
import kotlinx.coroutines.flow.flow

class UserDetailsDataSource(
    private val apiService: UserDetailsApi,
    private val mapper: UserDetailsMapper
) : UserDetailsRepository {

    override fun getUserDetails(userId: Int) = flow {
        val details = apiService.getUserDetails(userId)
        emit(mapper.translate(details))
    }
}