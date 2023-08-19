package com.lbg.testapp.presentation.ui.viewmodel

import androidx.lifecycle.Observer
import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.domain.interactor.UserInteractor
import com.lbg.testapp.mock.UserMock.oneUser
import com.lbg.testapp.presentation.ui.userdetail.UserDetailViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test

/**
 * Created by Siva kumar boddu 
 */
class UserDetailViewModelTest : BaseViewModelTest() {

    private val interactor = mockk<UserInteractor>()

    private val loadingObserver = mockk<Observer<Boolean>>()

    private val userObserver = mockk<Observer<User>>()

    private val errorObserver = mockk<Observer<Throwable?>>()

    private val viewModel = UserDetailViewModel(interactor)

    @ExperimentalCoroutinesApi
    @Test
    fun `no interactions`() = runBlockingTest {
        every { userObserver.onChanged(any()) } just Runs

        viewModel.user.observeForever(userObserver)

        coVerify(exactly = 0) { interactor.getUser(1) }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `get user by id with success`() = runBlockingTest {
        coEvery { interactor.getUser(any()) } returns oneUser

        every { loadingObserver.onChanged(any()) } just Runs

        every { userObserver.onChanged(any()) } just Runs

        viewModel.loading.observeForever(loadingObserver)

        viewModel.user.observeForever(userObserver)

        viewModel.getUser(1)

        coVerify { interactor.getUser(1) }

        verify(exactly = 2) { loadingObserver.onChanged(any()) }

        verify { userObserver.onChanged(any()) }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `throws exception when get user`() = runBlockingTest {
        coEvery { interactor.getUser(any()) } throws Exception()

        every { loadingObserver.onChanged(any()) } just Runs

        every { userObserver.onChanged(any()) } just Runs

        every { errorObserver.onChanged(any()) } just Runs

        viewModel.loading.observeForever(loadingObserver)

        viewModel.user.observeForever(userObserver)

        viewModel.error.observeForever(errorObserver)

        viewModel.getUser(1)

        coVerify { interactor.getUser(1) }

        verify(exactly = 2) { loadingObserver.onChanged(any()) }

        verify(exactly = 0) { userObserver.onChanged(any()) }

        verify { errorObserver.onChanged(any()) }
    }

}
