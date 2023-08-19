package com.lbg.testapp.data.repository

import com.lbg.testapp.data.cache.UserDataStore
import com.lbg.testapp.data.entity.toDomain
import com.lbg.testapp.data.network.UserCloudStore
import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Siva kumar boddu 
 */
class UserRepositoryImp(
    private val cloudStore: UserCloudStore,
    private val userDataStore: UserDataStore
) : UserRepository {

    override suspend fun getUsers(refresh: Boolean): List<User> = withContext(Dispatchers.IO) {
        val userLocalList = getUsersFromLocal()
        if (userLocalList.isNotEmpty() &&  !refresh) {
            if (userDataStore.isExpired()) {
                getUsersFromRemote()
            } else {
                userLocalList
            }
        } else {
            getUsersFromRemote()
        }
    }

    private suspend fun getUsersFromRemote(): List<User> = withContext(Dispatchers.IO) {
        val usersFromRemote = cloudStore.getUsers()
        if (usersFromRemote.isNotEmpty()) {
            userDataStore.saveUsers(usersFromRemote).map { it.toDomain() }
        } else {
            getUsersFromLocal()
        }
    }

    private suspend fun getUsersFromLocal(): List<User> = withContext(Dispatchers.IO) {
        userDataStore.getUsers().map { it.toDomain() }
    }

    override suspend fun getUser(userId: Long): User = withContext(Dispatchers.IO) {
        userDataStore.getUser(userId).toDomain()
    }

    override suspend fun setFavourite(userId: Long, isFavourite: Boolean) = withContext(Dispatchers.IO) {
        userDataStore.setFavourite(userId, isFavourite)
    }
}