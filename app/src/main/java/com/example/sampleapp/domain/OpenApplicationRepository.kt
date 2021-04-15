package com.example.sampleapp.domain

import kotlinx.coroutines.flow.Flow

interface OpenApplicationRepository {
    fun checkIsFirstOpen(): Flow<Boolean>
}