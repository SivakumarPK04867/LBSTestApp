package com.lbg.testapp.presentation

import android.app.Application
import com.lbg.testapp.BuildConfig.DEBUG
import com.lbg.testapp.core.util.listByElementsOf
import com.lbg.testapp.data.di.dataModules
import com.lbg.testapp.domain.di.domainModules
import com.lbg.testapp.presentation.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber

/**
 * Created by Siva kumar boddu 
 */
open class WiseTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if(DEBUG) Timber.plant(Timber.DebugTree())
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@WiseTestApp)
            koin.loadModules(modules)
        }
    }


    private val modules by lazy {
        listByElementsOf<Module>(
            dataModules,
            domainModules,
            presentationModules
        )
    }

}
