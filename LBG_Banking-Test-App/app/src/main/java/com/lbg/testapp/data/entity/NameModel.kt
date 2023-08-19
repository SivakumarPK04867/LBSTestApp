package com.lbg.testapp.data.entity

import com.lbg.testapp.domain.entity.Name

/**
 * Created by Siva kumar boddu 
 */

data class NameModel(
    val title: String,
    val first: String,
    val last: String
)

fun NameModel.toDomain() = Name(
    title = title,
    first = first,
    last = last
)