package com.lbg.testapp.data.di

import com.lbg.testapp.data.cache.di.cacheModule
import com.lbg.testapp.data.network.di.networkModule
import com.lbg.testapp.data.repository.di.repositoryModule
import com.lbg.testapp.core.util.listByElementsOf
import org.koin.core.module.Module

/**
 * Created by Siva kumar boddu
 */
internal val dataModules by lazy {
    listByElementsOf<Module>(
        cacheModule,
        networkModule,
        repositoriesModules
    )
}

internal val repositoriesModules by lazy {
    listByElementsOf<Module>(
        repositoryModule
    )
}
