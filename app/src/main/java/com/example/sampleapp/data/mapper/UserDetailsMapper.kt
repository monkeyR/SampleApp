package com.example.sampleapp.data.mapper

import com.example.sampleapp.data.model.UserDetailsEntity
import com.example.sampleapp.domain.details.UserDetailsModel
import com.example.sampleapp.presentation.common.DateFormatter

class UserDetailsMapper(private val dateFormatter: DateFormatter) {

    fun translate(userDetails: UserDetailsEntity) = UserDetailsModel(
        id = userDetails.id,
        name = userDetails.name,
        avatarUrl = userDetails.avatar_url,
        location = userDetails.location,
        followersCount = userDetails.followers,
        githubRepoCount = userDetails.public_repos,
        created = dateFormatter.parseDate(userDetails.created_at)
    )
}
