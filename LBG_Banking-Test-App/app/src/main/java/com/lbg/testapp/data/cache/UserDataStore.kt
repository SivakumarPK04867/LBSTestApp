package com.lbg.testapp.data.cache

import com.lbg.testapp.data.cache.dao.UserDao
import com.lbg.testapp.data.cache.entity.toData
import com.lbg.testapp.data.cache.system.PreferencesHelper
import com.lbg.testapp.data.entity.UserModel
import com.lbg.testapp.data.entity.toLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Siva kumar boddu 
 */
class UserDataStore(
    private val userDao: UserDao,
    private val preferencesHelper: PreferencesHelper
) {

    companion object {
        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong()
    }

    suspend fun getUsers(): List<UserModel> = withContext(Dispatchers.IO) {
        userDao.getAll().map { it.toData() }
    }

    suspend fun getUser(userId: Long): UserModel = withContext(Dispatchers.IO) {
        userDao.getUserById(userId).toData()
    }

    suspend fun saveUsers(users: List<UserModel>): List<UserModel> = withContext(Dispatchers.IO) {
        userDao.deteleAll()
        userDao.insertAll(users.map { it.toLocal() })
        setLastCacheTime(System.currentTimeMillis())
        userDao.getAll().map { it.toData() }
    }

    suspend fun setFavourite(userId: Long, isFavourite: Boolean) {
        userDao.setFavourite(userId, isFavourite)
    }

    private fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

    fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }
}