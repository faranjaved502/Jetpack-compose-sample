package com.faran.jetpackapp.data.api

import com.faran.jetpackapp.data.response.UserResponseDTO
import com.faran.jetpackapp.data.response.UserResponsePhotosDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {

    @GET("/users")
    fun getAllUsers(): Call<List<UserResponseDTO>>

    @GET("/photos")
    fun getUserPhotos(
        @Query("albumId") id: Int,
    ): Call<List<UserResponsePhotosDTO>>
}