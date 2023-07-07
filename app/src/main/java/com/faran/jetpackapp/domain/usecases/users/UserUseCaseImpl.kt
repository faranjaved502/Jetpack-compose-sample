package com.faran.jetpackapp.domain.usecases.users

import com.faran.jetpackapp.core.utils.isSuccess
import com.faran.jetpackapp.data.services.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val userService: UserService
): UserUseCase {

    override suspend fun execute(inputT: Any): UserUseCase.Result {
        return withContext(Dispatchers.IO) {
            val result = userService.getAllUsers()

            if (result.isSuccess()) {
                val response = result.response
                if (response != null) {
                    UserUseCase.Result.Success(result.response)
                } else {
                    UserUseCase.Result.Error("Response is empty")
                }
            } else {
                UserUseCase.Result.Error(result.error?.errorMessage ?: "")
            }
        }
    }
}