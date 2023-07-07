package com.faran.jetpackapp.data.mapper

import com.faran.jetpackapp.core.network.mapper.DomainMapper
import com.faran.jetpackapp.domain.entities.user.UserData
import com.faran.jetpackapp.data.response.UserResponseDTO

class UserMapper : DomainMapper<List<UserResponseDTO>, List<UserData>> {

    override fun map(response: List<UserResponseDTO>): List<UserData> =
        response.map { UserData(it.id, it.name, it.phone, it.email) }

    override fun getApiResponseType(): Class<List<UserResponseDTO>> =
        listOf<UserResponseDTO>().javaClass
}