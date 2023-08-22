package com.lbg.testapp.data.network.di

import com.lbg.testapp.core.util.NetworkConnectivity
import com.lbg.testapp.data.network.UserCloudStore
import com.lbg.testapp.data.network.util.buildOkHttpClient
import com.lbg.testapp.data.network.util.buildRetrofit
import com.lbg.testapp.data.network.api.WiseTestApi
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Siva kumar boddu 
 */

const val NAMED = "WISE_TEST"
const val NAMED_CLIENT = "WISE_TEST_CLIENT"

internal val networkModule = module(override = true) {
    single(named(NAMED_CLIENT)) { createHttpClient() }
    single(named(NAMED)) { createRetrofit(get(named(NAMED_CLIENT))) }
    single { provideApi(get(named(NAMED))) }
    single { NetworkConnectivity(get()) }
    single { UserCloudStore(get(), get()) }
}

private fun createHttpClient(): OkHttpClient {
    return buildOkHttpClient()
}

private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return buildRetrofit(okHttpClient)
}

private fun provideApi(retrofit: Retrofit): WiseTestApi {
    return retrofit.create(WiseTestApi::class.java)
}