package com.faran.jetpackapp.presentation.home

import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.domain.usecases.users.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UserUseCase
) : HomeViewModelContract.ViewModel() {

    private val _usersList = MutableStateFlow<List<UserData>>(emptyList())

    override fun getUserList(): StateFlow<List<UserData>> = _usersList.asStateFlow()

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        launch(Dispatchers.IO) {
            when (val result = useCase.execute("")) {
                is UserUseCase.Result.Success -> {
                    _usersList.value = result.usersList
                }
                is UserUseCase.Result.Error -> result.message
            }
        }
    }
}