package com.lbg.testapp.domain.interactor.implementation

import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.domain.interactor.UserInteractor
import com.lbg.testapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * Created by Siva kumar boddu 
 */
class UserInteractorImp(
    private val repository: UserRepository
) : UserInteractor {

    override suspend fun getUsers(refresh: Boolean): List<User> = withContext(IO) {
        repository.getUsers(refresh)
    }

    override suspend fun getUser(id: Long): User = withContext(IO) {
        repository.getUser(id)
    }

    override suspend fun setFavourite(userId: Long, isFavourite: Boolean) {
        repository.setFavourite(userId, isFavourite)
    }
}
