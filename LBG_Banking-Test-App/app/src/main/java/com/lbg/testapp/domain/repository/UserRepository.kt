package com.lbg.testapp.domain.repository

import com.lbg.testapp.domain.entity.User

/**
 * Created by Siva kumar boddu 
 */
interface UserRepository {
    suspend fun getUsers(refresh: Boolean): List<User>
    suspend fun getUser(userId: Long): User
    suspend fun setFavourite(userId: Long, isFavourite: Boolean)
}