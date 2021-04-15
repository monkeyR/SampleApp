package com.example.sampleapp.domain.common

import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

fun <T> Flow<T>.asStatusLiveData(coroutineContext: CoroutineContext, timeout: Long) =
    liveData(coroutineContext, timeout) {
        emit(StatusResult(status = Status.IN_PROGRESS))

        var value: T? = null
        try {
            collect { value = it }
        } catch (exception: Exception) {
            emit(
                StatusResult(
                    status = Status.FINISHED,
                    throwable = exception
                )
            )
            return@liveData
        }
        emit(
            StatusResult(
                status = Status.FINISHED,
                data = value,
                throwable = null
            )
        )
    }

