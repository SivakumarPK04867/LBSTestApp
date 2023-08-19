package com.lbg.testapp.data.entity

import com.lbg.testapp.data.cache.entity.UserEntity
import com.lbg.testapp.domain.entity.User

/**
 * Created by Siva kumar boddu 
 */
data class UserModel(
    val id: Long = 0,
    val gender: String,
    val name: NameModel,
    val email: String,
    val picture: PictureModel,
    val favourite: Boolean
)

fun UserModel.toDomain() = User(
    id = id,
    gender = gender,
    name = name.toDomain(),
    email = email,
    picture = picture.toDomain(),
    favourite = favourite
)

fun UserModel.toLocal() = UserEntity (
    gender = gender,
    title = name.title,
    first = name.first,
    lastName = name.last,
    email = email,
    imageLarge = picture.large,
    imageMedium = picture.medium,
    thumbnail = picture.thumbnail,
    favourite = favourite
)