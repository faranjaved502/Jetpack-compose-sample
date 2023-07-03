package com.faran.jetpackapp.domain.usecases.userdetail

import com.faran.jetpackapp.core.utils.isSuccess
import com.faran.jetpackapp.data.services.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailUseCaseImpl @Inject constructor(
    private val userService: UserService
): DetailUseCase {

    override suspend fun execute(inputT: DetailUseCase.Params): DetailUseCase.Result {
        return withContext(Dispatchers.IO) {
            val result = userService.getUserPhotos(inputT.id)
            if (result.isSuccess()) {
                val response = result.response
                if (response != null) {
                    DetailUseCase.Result.Success(result.response)
                } else DetailUseCase.Result.Error("Response is empty")
            } else {
                DetailUseCase.Result.Error(result.error?.errorMessage ?: "")
            }
        }
    }
}