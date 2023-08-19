package com.lbg.testapp.data.network.api

import com.lbg.testapp.data.network.entity.BaseResponse
import com.lbg.testapp.data.network.entity.UserResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Siva kumar boddu 
 */
interface WiseTestApi {

    @GET("api/?results=20")
    suspend fun getUsers(): Response<BaseResponse<List<UserResponse>>>

}