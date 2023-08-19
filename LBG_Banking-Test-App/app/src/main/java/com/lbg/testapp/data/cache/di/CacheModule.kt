package com.lbg.testapp.data.cache.di

import com.lbg.testapp.data.cache.UserDataStore
import com.lbg.testapp.data.cache.system.PreferencesHelper
import com.lbg.testapp.data.cache.system.SystemDatabase
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu 
 */
internal val cacheModule = module {
    single { SystemDatabase.newInstance(get()) }
    single { get<SystemDatabase>().userDao() }
    single { PreferencesHelper(get()) }
    single { UserDataStore(get(), get()) }
}