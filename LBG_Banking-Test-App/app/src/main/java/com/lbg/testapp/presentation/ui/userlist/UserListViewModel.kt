package com.lbg.testapp.presentation.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lbg.testapp.domain.entity.User
import com.lbg.testapp.domain.interactor.UserInteractor
import com.lbg.testapp.presentation.ui.CoroutinesViewModel

/**
 * Created by Siva kumar boddu 
 */
class UserListViewModel(
    private val interactor: UserInteractor
) : CoroutinesViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val _users = MutableLiveData<List<User>>()
    private val _error = MutableLiveData<Throwable>()

    val loading: LiveData<Boolean> get() = _loading
    val users: LiveData<List<User>> get() = _users
    val error: LiveData<Throwable> get() = _error

    fun getUsers(refresh: Boolean = false) {
        launch {
            try {
                _loading.value = true
                _users.value = interactor.getUsers(refresh)
            } catch (exception: Exception) {
                _error.value = exception
            } finally {
                _loading.value = false
            }
        }
    }

}
