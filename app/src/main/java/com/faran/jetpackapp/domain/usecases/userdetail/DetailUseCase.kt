package com.faran.jetpackapp.domain.usecases.userdetail

import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.mvvm.usecase.UseCase

interface DetailUseCase: UseCase<DetailUseCase.Params, DetailUseCase.Result> {

    data class Params(
        val id: Int
    )

    sealed class Result {
        data class Success(val photosList: List<UserPhotosData>) : Result()
        data class Error(val message: String) : Result()
    }
}