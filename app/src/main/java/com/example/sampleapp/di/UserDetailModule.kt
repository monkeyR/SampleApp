package com.example.sampleapp.di

import com.example.sampleapp.data.api.UserDetailsApi
import com.example.sampleapp.data.mapper.UserDetailsMapper
import com.example.sampleapp.data.repository.UserDetailsDataSource
import com.example.sampleapp.domain.details.UserDetailsRepository
import com.example.sampleapp.presentation.details.UserDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val UserDetailsModule = module {

    viewModel { UserDetailsViewModel(get()) }

    single { UserDetailsMapper(get()) }

    single<UserDetailsRepository> { UserDetailsDataSource(createUserDetailsService(get()), get()) }
}

fun createUserDetailsService(retrofit: Retrofit): UserDetailsApi {
    return retrofit.create(UserDetailsApi::class.java)
}