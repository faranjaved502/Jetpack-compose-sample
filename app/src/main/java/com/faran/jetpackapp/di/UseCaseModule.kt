package com.faran.jetpackapp.di

import com.faran.jetpackapp.data.services.UserService
import com.faran.jetpackapp.domain.usecases.users.UserUseCase
import com.faran.jetpackapp.domain.usecases.users.UserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserUseCase(userService: UserService): UserUseCase = UserUseCaseImpl(userService)
}