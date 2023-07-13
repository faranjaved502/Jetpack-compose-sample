package com.faran.jetpackapp.feature.user

import com.faran.jetpackapp.domain.entities.user.UserData
import com.faran.jetpackapp.domain.usecases.users.UserUseCase
import com.faran.jetpackapp.framework.ViewModelBaseTest
import com.faran.jetpackapp.presentation.home.HomeViewModel
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import kotlin.test.assertEquals

class UserViewModelTest: ViewModelBaseTest() {

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    lateinit var userUseCaseMock: UserUseCase

    @Before
    fun setUp() {
        super.setUpBase()
        homeViewModel = HomeViewModel(userUseCaseMock)
    }


    @Test
    fun testGetUserData() = runBlocking {
        //given

        //when
        whenever(userUseCaseMock.execute(""))
            .thenReturn(UserUseCase.Result.Success(getMockUserResponse()))

        //then
        homeViewModel.fetchUserData()

        // Assert
        assertEquals(false, homeViewModel.loadingState().value)
        assertEquals(getMockUserResponse(), homeViewModel.getUserList().value)
    }


    private fun getMockUserResponse() =
        listOf(
            UserData(
                id = 1,
                name = "name",
                phone = "phone",
                email = "email"
            )
        )
}