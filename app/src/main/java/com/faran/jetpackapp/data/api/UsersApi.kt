package com.faran.jetpackapp.data.api

import com.faran.jetpackapp.data.user.network.response.UserResponseDTO
import retrofit2.Call
import retrofit2.http.GET

interface UsersApi {

    @GET("/users")
    fun getAllUsers(): Call<List<UserResponseDTO>>

    @GET("/photos")
    fun getAllPhotos(): Call<UserResponseDTO>
}