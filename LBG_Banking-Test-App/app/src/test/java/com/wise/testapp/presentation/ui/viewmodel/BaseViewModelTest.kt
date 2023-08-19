package com.lbg.testapp.presentation.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lbg.testapp.presentation.ui.viewmodel.rule.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule

/**
 * Created by Siva kumar boddu 
 */
open class BaseViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @ExperimentalCoroutinesApi
    protected inline fun runBlockingTest(crossinline block: () -> Unit) =
        coroutinesTestRule.testDispatcher.runBlockingTest { block() }

}