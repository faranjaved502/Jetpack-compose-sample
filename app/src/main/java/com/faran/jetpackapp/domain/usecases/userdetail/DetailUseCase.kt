package com.faran.jetpackapp.domain.usecases.userdetail

import com.faran.jetpackapp.domain.entities.user.UserPhotosData
import com.faran.jetpackapp.domain.mvvm.usecase.UseCase

interface DetailUseCase: UseCase<DetailUseCase.Params, DetailUseCase.Result> {

    data class Params(
        val id: Int
    )

    sealed class Result {
        data class Success(val photosList: List<UserPhotosData>) : Result()
        data class Error(val message: String) : Result()
    }
}