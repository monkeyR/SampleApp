package com.example.sampleapp.data.api

import com.example.sampleapp.data.model.UserEntity
import retrofit2.http.GET

interface UserListApi {

    @GET("users")
    suspend fun getUserList(): ArrayList<UserEntity>
}