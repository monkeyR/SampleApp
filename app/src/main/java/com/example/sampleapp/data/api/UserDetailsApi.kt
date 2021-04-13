package com.example.sampleapp.data.api

import com.example.sampleapp.data.model.UserDetailsEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailsApi {

    @GET("users/{id}")
    suspend fun getUserDetails(@Path("id", encoded = false) id: Int): UserDetailsEntity
}