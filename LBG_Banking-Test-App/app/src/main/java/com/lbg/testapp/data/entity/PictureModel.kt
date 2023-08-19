package com.lbg.testapp.data.entity

import com.lbg.testapp.domain.entity.Picture

/**
 * Created by Siva kumar boddu 
 */
data class PictureModel(
    val large: String,
    val medium: String,
    val thumbnail: String
)

fun PictureModel.toDomain() = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail
)