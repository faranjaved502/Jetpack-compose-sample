package com.faran.jetpackapp.mvvm.usecase

interface UseCase<InputT, OutputT> {

    suspend fun execute(inputT: InputT): OutputT
}