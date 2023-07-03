package com.faran.jetpackapp.data.services

import com.faran.jetpackapp.core.domain.ApiResult
import com.faran.jetpackapp.core.network.RetrofitCallExecutor
import com.faran.jetpackapp.data.api.UsersApi
import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.data.user.network.mapper.UserMapper
import com.faran.jetpackapp.data.user.network.mapper.UserPhotosMapper
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val api: UsersApi
): UserService {

    override fun getAllUsers(): ApiResult<List<UserData>> {
       val call = api.getAllUsers()

        return RetrofitCallExecutor(domainMapper = UserMapper()).execute(call)
    }

    override fun getUserPhotos(id: Int): ApiResult<List<UserPhotosData>> {
        val call = api.getUserPhotos(id)

        return RetrofitCallExecutor(domainMapper = UserPhotosMapper()).execute(call)
    }
}