package com.lbg.testapp.data.repository.di

import com.lbg.testapp.data.repository.UserRepositoryImp
import com.lbg.testapp.domain.repository.UserRepository
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu 
 */
val repositoryModule = module(override = true) {
    single<UserRepository> { UserRepositoryImp(get(), get()) }
    single<UserRepository> { UserRepositoryImp(get(), get()) }
}