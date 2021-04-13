package com.example.sampleapp.domain.userlist

import kotlinx.coroutines.flow.Flow

interface UserListRepository {
     fun getUsers(): Flow<List<UserModel>>
}