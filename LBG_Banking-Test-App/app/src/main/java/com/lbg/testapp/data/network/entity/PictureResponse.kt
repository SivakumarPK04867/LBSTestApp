package com.lbg.testapp.data.network.entity

import com.lbg.testapp.data.entity.PictureModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Siva kumar boddu 
 */
@Serializable
data class PictureResponse(
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("thumbnail")
    val thumbnail: String
)

fun PictureResponse.toData() = PictureModel(
    large = large,
    medium = medium,
    thumbnail = thumbnail
)