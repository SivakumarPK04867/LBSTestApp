package com.lbg.testapp.data

import com.lbg.testapp.data.cache.UserDataStore
import com.lbg.testapp.data.network.UserCloudStore
import com.lbg.testapp.data.repository.UserRepositoryImp
import com.lbg.testapp.core.exception.NotFoundException
import com.lbg.testapp.mock.UserMock.oneUserModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
/**
 * Created by Siva kumar boddu 
 */
class UserRepositoryTest {

    private val dataStore = mockk<UserDataStore>()
    private val cloudStore = mockk<UserCloudStore>()
    private val userRepository = UserRepositoryImp(cloudStore, dataStore)

    @Test
    fun `should return a list containing users`() = runBlocking {
        coEvery { dataStore.getUsers() } returns arrayListOf(oneUserModel)
        coEvery { dataStore.isExpired() } returns false
        val result = userRepository.getUsers(false)
        coVerify { dataStore.getUsers() }
        Assert.assertEquals(1, result.size)
    }


    @Test(expected = NotFoundException::class)
    fun `should throw an exception when get a user by id`() = runBlocking {
        coEvery { dataStore.getUser(any()) } throws NotFoundException()

        userRepository.getUser(1)

        coVerify { dataStore.getUser(any()) }
    }

}