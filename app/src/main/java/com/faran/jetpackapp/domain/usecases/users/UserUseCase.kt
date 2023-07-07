package com.faran.jetpackapp.domain.usecases.users

import com.faran.jetpackapp.domain.entities.user.UserData
import com.faran.jetpackapp.domain.mvvm.usecase.UseCase

interface UserUseCase: UseCase<Any, UserUseCase.Result> {

    sealed class Result {
        data class Success(val usersList: List<UserData>) : Result()
        data class Error(val message: String) : Result()
    }
}