package com.faran.jetpackapp.presentation.userDetails

import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

interface UserDetailViewModelContract {

    abstract class ViewModel: BaseViewModel() {

        abstract fun getUserPhotosList(): StateFlow<List<UserPhotosData>>
    }
}