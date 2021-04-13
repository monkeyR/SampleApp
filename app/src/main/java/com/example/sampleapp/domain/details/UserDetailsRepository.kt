package com.example.sampleapp.domain.details

import kotlinx.coroutines.flow.Flow

interface UserDetailsRepository {

    fun getUserDetails(userId: Int): Flow<UserDetailsModel>
}