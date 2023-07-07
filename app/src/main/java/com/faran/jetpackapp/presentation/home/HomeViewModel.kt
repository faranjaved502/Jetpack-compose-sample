package com.faran.jetpackapp.presentation.home

import com.faran.jetpackapp.domain.entities.user.UserData
import com.faran.jetpackapp.domain.usecases.users.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val _loadingState = MutableStateFlow(false)

    override fun getUserList(): StateFlow<List<UserData>> = _usersList.asStateFlow()
    override fun loadingState(): StateFlow<Boolean>  = _loadingState.asStateFlow()

    init {
        fetchUserData()
    }

    private fun fetchUserData() {
        launch {
            _loadingState.value = true
            when (val result = useCase.execute("")) {
                is UserUseCase.Result.Success -> {
                    _loadingState.value = false
                    _usersList.value = result.usersList
                }
                is UserUseCase.Result.Error -> {
                    _loadingState.value = false
                    result.message
                }
            }
        }
    }
}