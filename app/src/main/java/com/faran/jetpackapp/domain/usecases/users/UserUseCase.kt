package com.faran.jetpackapp.domain.usecases.users

import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.mvvm.usecase.UseCase

interface UserUseCase: UseCase<Any, UserUseCase.Result> {

    sealed class Result {
        data class Success(val usersList: List<UserData>) : Result()
        data class Error(val message: String) : Result()
    }
}