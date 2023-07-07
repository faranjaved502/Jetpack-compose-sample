package com.faran.jetpackapp.presentation.userDetails

import androidx.lifecycle.SavedStateHandle
import com.faran.jetpackapp.domain.entities.user.UserPhotosData
import com.faran.jetpackapp.domain.usecases.userdetail.DetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val useCase: DetailUseCase,
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()
): UserDetailViewModelContract.ViewModel() {

    private val _photosList = MutableStateFlow<List<UserPhotosData>>(emptyList())
    private val _loadingState = MutableStateFlow(false)

    override fun getUserPhotosList(): StateFlow<List<UserPhotosData>> = _photosList.asStateFlow()
    override fun loadingState(): StateFlow<Boolean>  = _loadingState.asStateFlow()

    init {
        getUserPhotos()
    }

    private fun getUserPhotos() {
        launch {
            val id = savedStateHandle.get<Int?>("id")
            _loadingState.value = true
            when (val result = useCase.execute( DetailUseCase.Params(id?: 0) )) {

                is DetailUseCase.Result.Success -> {
                    _loadingState.value = false
                    _photosList.value = result.photosList
                }
                is DetailUseCase.Result.Error -> {
                    _loadingState.value = false
                    result.message
                }
            }
        }
    }
}