package com.lbg.testapp.presentation.di

import com.lbg.testapp.presentation.ui.userdetail.UserDetailViewModel
import com.lbg.testapp.presentation.ui.userlist.UserListViewModel
import com.lbg.testapp.core.util.listByElementsOf
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu 
 */
internal val presentationModules by lazy {
    listByElementsOf<Module>(
        viewModelModule
    )
}

internal val viewModelModule = module {
    viewModel { UserListViewModel(get()) }
    viewModel { UserDetailViewModel(get()) }
}