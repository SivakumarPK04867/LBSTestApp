package com.lbg.testapp.data.network

import com.lbg.testapp.data.entity.UserModel
import com.lbg.testapp.data.network.api.WiseTestApi
import com.lbg.testapp.data.network.entity.toData
import com.lbg.testapp.core.exception.NotFoundException
import com.lbg.testapp.core.util.NetworkConnectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Siva kumar boddu
 */
class UserCloudStore(private val api: WiseTestApi,
                     private val networkConnectivity: NetworkConnectivity) {

    suspend fun getUsers(): List<UserModel> = withContext(Dispatchers.IO) {
        if (networkConnectivity.isInternetOn()) {
            api.getUsers().let { response ->
                response.body()?.results?.map { it.toData() } ?: throw NotFoundException()
            }
        } else {
            arrayListOf()
        }
    }
}