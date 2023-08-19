package com.lbg.testapp.domain

import com.lbg.testapp.core.exception.NotFoundException
import com.lbg.testapp.domain.interactor.implementation.UserInteractorImp
import com.lbg.testapp.domain.repository.UserRepository
import com.lbg.testapp.mock.UserMock.oneUser
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Siva kumar boddu 
 */
class UserInteractorTest {

    private val repository = mockk<UserRepository>()
    private val interactor = UserInteractorImp(repository)

    @Test
    fun `should return an empty list of users`() = runBlocking {
        coEvery { repository.getUsers(false) } returns emptyList()
        val result = interactor.getUsers(false)
        coVerify { repository.getUsers(false) }
        Assert.assertEquals(0, result.size)
    }

    @Test
    fun `should return a list containing users`() = runBlocking {
        val userList = arrayListOf(oneUser)
        coEvery { repository.getUsers(false) } returns userList
        val result = interactor.getUsers(false)
        coVerify { repository.getUsers(false) }
        Assert.assertEquals(userList, result)
    }

    @Test
    fun `should find a user by id`() = runBlocking {
        val userMock = oneUser
        coEvery { repository.getUser(any()) } returns userMock
        val result = interactor.getUser(1)
        coVerify { repository.getUser(any()) }
        Assert.assertEquals(userMock, result)
    }

    @Test(expected = NotFoundException::class)
    fun `shouldn't find a user by id`() = runBlocking {
        coEvery { repository.getUser(any()) } throws NotFoundException()
        interactor.getUser(1)
        coVerify { repository.getUser(any()) }
    }

}