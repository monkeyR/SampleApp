package com.example.sampleapp.di

import com.example.sampleapp.data.repository.DataStoreOpenApplicationRepository
import com.example.sampleapp.domain.OpenApplicationRepository
import com.example.sampleapp.presentation.MainViewModel
import com.example.sampleapp.presentation.common.DateFormatter
import com.example.sampleapp.presentation.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ApplicationModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { SplashViewModel() }

    single<OpenApplicationRepository> { DataStoreOpenApplicationRepository(get()) }

    single { createDateFormatter() }
}

fun createDateFormatter() = DateFormatter()
