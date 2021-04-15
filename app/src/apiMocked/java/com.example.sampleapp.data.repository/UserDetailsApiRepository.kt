package com.example.sampleapp.data.repository

import android.content.Context
import com.example.sampleapp.data.api.UserDetailsApi
import com.example.sampleapp.data.mapper.UserDetailsMapper
import com.example.sampleapp.data.model.UserDetailsEntity
import com.example.sampleapp.domain.details.UserDetailsRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserDetailsApiRepository(
    private val apiService: UserDetailsApi,
    private val mapper: UserDetailsMapper
) : UserDetailsRepository, KoinComponent {

    private val context: Context by inject()
    private val jsonDataUtils = JsonDataUtils()
    private val gson = Gson()

    override fun getUserDetails(userId: Int) = flow {
        val jsonData = jsonDataUtils.getJsonDataFromAsset(context, "mockedUserDetails.json")
        val details = gson.fromJson(jsonData, UserDetailsEntity::class.java)
        emit(mapper.translate(details))
    }

}