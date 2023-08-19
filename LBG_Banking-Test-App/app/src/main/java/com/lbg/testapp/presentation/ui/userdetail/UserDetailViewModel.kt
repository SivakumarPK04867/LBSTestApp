package com.lbg.testapp.presentation.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.domain.interactor.UserInteractor
import com.lbg.testapp.presentation.ui.CoroutinesViewModel

/**
 * Created by Siva kumar boddu 
 */
class UserDetailViewModel(
    private val interactor: UserInteractor
) : CoroutinesViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val _user = MutableLiveData<User>()
    private val _error = MutableLiveData<Throwable?>()

    val loading: LiveData<Boolean> get() = _loading
    val user: LiveData<User> get() = _user
    val error: LiveData<Throwable?> get() = _error

    fun getUser(userId: Long) {
        launch {
            try {
                _loading.value = true
                _user.value = interactor.getUser(userId)
                _error.value = null
            } catch (exception: Exception) {
                _error.value = exception
            } finally {
                _loading.value = false
            }
        }
    }

    fun setFavourite(userId: Long?, isFavourite: Boolean) {
        launch {
            userId?.let {
                interactor.setFavourite(it, isFavourite)
            }
        }
    }
}