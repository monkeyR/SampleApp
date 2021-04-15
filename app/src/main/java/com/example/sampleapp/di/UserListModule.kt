package com.example.sampleapp.di

import com.example.sampleapp.data.api.UserListApi
import com.example.sampleapp.data.mapper.UserMapper
import com.example.sampleapp.data.repository.UserListApiRepository
import com.example.sampleapp.domain.userlist.UserListRepository
import com.example.sampleapp.presentation.userlist.UserListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val UserListModule = module {

    viewModel { UserListViewModel(get()) }

    single { UserMapper() }

    single<UserListRepository> { UserListApiRepository(createUserListService(get()), get()) }
}

fun createUserListService(retrofit: Retrofit): UserListApi {
    return retrofit.create(UserListApi::class.java)
}
