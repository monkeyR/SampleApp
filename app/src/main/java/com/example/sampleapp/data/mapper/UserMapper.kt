package com.example.sampleapp.data.mapper

import com.example.sampleapp.data.model.UserEntity
import com.example.sampleapp.domain.userlist.UserModel

class UserMapper {

    fun translate(userEntity: UserEntity) =
        UserModel(userEntity.id, userEntity.login, userEntity.avatar_url)
}