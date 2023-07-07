package com.faran.jetpackapp.domain.mvvm.usecase

interface UseCase<InputT, OutputT> {

    suspend fun execute(inputT: InputT): OutputT
}