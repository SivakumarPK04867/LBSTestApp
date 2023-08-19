package com.lbg.testapp.data.network.entity

import com.lbg.testapp.data.entity.NameModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Siva kumar boddu 
 */
@Serializable
data class NameResponse(
    @SerialName("title")
    val title: String,
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String
)

fun NameResponse.toData() = NameModel(
    title = title,
    first = first,
    last = last
)