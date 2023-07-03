package com.faran.jetpackapp.data.services

import com.faran.jetpackapp.core.domain.ApiResult
import com.faran.jetpackapp.data.user.domain.UserData

interface UserService {

    fun getAllUsers(): ApiResult<List<UserData>>
}