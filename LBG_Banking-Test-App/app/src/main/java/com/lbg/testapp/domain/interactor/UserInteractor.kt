package com.lbg.testapp.domain.interactor

import com.lbg.testapp.domain.entity.User

/**
 * Created by Siva kumar boddu 
 */
interface UserInteractor {
    suspend fun getUsers(refresh: Boolean): List<User>
    suspend fun getUser(id: Long): User
    suspend fun setFavourite(userId: Long, isFavourite: Boolean)
}
