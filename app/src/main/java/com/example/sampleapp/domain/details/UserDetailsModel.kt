package com.example.sampleapp.domain.details

import java.util.*

data class UserDetailsModel(
    val id: Int,
    val name: String,
    val avatarUrl: String?,
    val location: String?,
    val followersCount: Int?,
    val githubRepoCount: Int?,
    val created: Date?
)