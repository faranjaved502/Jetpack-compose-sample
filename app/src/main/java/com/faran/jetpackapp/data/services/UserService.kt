package com.faran.jetpackapp.data.services

import com.faran.jetpackapp.core.domain.ApiResult
import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.data.user.domain.UserPhotosData

interface UserService {
    fun getAllUsers(): ApiResult<List<UserData>>

    fun getUserPhotos(id: Int): ApiResult<List<UserPhotosData>>
}