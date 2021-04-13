package com.example.sampleapp.domain

open class StatusResult<T>(
    val data: T? = null,
    val throwable: Throwable? = null,
    val status: Status = Status.IN_PROGRESS
) {
    val isSuccess = throwable == null
}
