package com.example.sampleapp.data.repository

import android.content.Context
import com.example.sampleapp.data.api.UserListApi
import com.example.sampleapp.data.mapper.UserMapper
import com.example.sampleapp.data.model.UserEntity
import com.example.sampleapp.domain.userlist.UserListRepository
import com.example.sampleapp.domain.userlist.UserModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import org.koin.core.KoinComponent
import org.koin.core.inject


class UserListApiRepository(
    private val apiService: UserListApi,
    private val mapper: UserMapper
) : UserListRepository, KoinComponent {

    private val context: Context by inject()

    private val jsonDataUtils = JsonDataUtils()
    private val gson = Gson()

    override fun getUsers() = flow {
        val jsonData = jsonDataUtils.getJsonDataFromAsset(context, "mockedUserList.json")
        val userList: List<UserModel> =
            gson.fromJson(jsonData, Array<UserEntity>::class.java).map {
                mapper.translate(it)
            }
        emit(userList)
    }
}