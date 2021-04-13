package com.example.sampleapp.di

import com.example.sampleapp.presentation.utils.DateFormatter
import org.koin.dsl.module

val ApplicationModule = module {

    single { createDateFormatter() }
}

fun createDateFormatter() = DateFormatter()
