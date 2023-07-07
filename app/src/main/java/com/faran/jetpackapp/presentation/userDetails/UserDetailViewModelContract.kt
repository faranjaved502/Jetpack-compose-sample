package com.faran.jetpackapp.presentation.userDetails

import com.faran.jetpackapp.domain.entities.user.UserPhotosData
import com.faran.jetpackapp.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

interface UserDetailViewModelContract {

    abstract class ViewModel: BaseViewModel() {
        abstract fun getUserPhotosList(): StateFlow<List<UserPhotosData>>

        abstract fun loadingState(): StateFlow<Boolean>

    }
}