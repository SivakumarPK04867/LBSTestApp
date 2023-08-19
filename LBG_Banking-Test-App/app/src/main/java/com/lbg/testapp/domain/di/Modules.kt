package com.lbg.testapp.domain.di

import com.lbg.testapp.domain.interactor.UserInteractor
import com.lbg.testapp.domain.interactor.implementation.UserInteractorImp
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu 
 */
internal val domainModules = module {
    single<UserInteractor> { UserInteractorImp(get()) }
}