package com.faran.jetpackapp.presentation.userDetails

import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.domain.usecases.userdetail.DetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val useCase: DetailUseCase
): UserDetailViewModelContract.ViewModel() {

    private val _photosList = MutableStateFlow<List<UserPhotosData>>(emptyList())

    override fun getUserPhotosList(): StateFlow<List<UserPhotosData>> = _photosList

    fun getUserPhotos(id: Int) {
        launch {
            when (val result = useCase.execute(DetailUseCase.Params(id))) {
                is DetailUseCase.Result.Success -> {
                    _photosList.value = result.photosList
                }
                is DetailUseCase.Result.Error -> result.message
            }
        }
    }
}