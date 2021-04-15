package com.example.sampleapp.data.repository

import com.example.sampleapp.data.api.UserListApi
import com.example.sampleapp.data.mapper.UserMapper
import com.example.sampleapp.domain.userlist.UserListRepository
import kotlinx.coroutines.flow.flow

class UserListApiRepository(
    private val apiService: UserListApi,
    private val mapper: UserMapper
) : UserListRepository {

    override fun getUsers() = flow {
        val userList = apiService.getUserList()
            .map { mapper.translate(it) }
        emit(userList)
    }
}