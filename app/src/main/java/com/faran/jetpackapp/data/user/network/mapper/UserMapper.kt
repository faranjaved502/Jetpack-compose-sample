package com.faran.jetpackapp.data.user.network.mapper

import com.faran.jetpackapp.core.network.mapper.DomainMapper
import com.faran.jetpackapp.data.user.domain.UserData
import com.faran.jetpackapp.data.user.network.response.UserResponseDTO

class UserMapper : DomainMapper<List<UserResponseDTO>, List<UserData>> {

    override fun map(response: List<UserResponseDTO>): List<UserData> =
        response.map { UserData(it.id, it.name, it.phone, it.email) }

    override fun getApiResponseType(): Class<List<UserResponseDTO>> =
        listOf<UserResponseDTO>().javaClass
}