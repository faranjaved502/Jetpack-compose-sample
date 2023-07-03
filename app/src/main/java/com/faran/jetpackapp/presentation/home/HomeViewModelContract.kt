package com.faran.jetpackapp.presentation.home

import com.faran.jetpackapp.presentation.base.BaseViewModel
import com.faran.jetpackapp.data.user.domain.UserData
import kotlinx.coroutines.flow.StateFlow

interface HomeViewModelContract {

    abstract class ViewModel: BaseViewModel() {
        abstract fun getUserList(): StateFlow<List<UserData>>
    }
}