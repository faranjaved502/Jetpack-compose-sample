package com.faran.jetpackapp.data.user.network.mapper

import com.faran.jetpackapp.core.network.mapper.DomainMapper
import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.data.user.network.response.UserResponsePhotosDTO

class UserPhotosMapper: DomainMapper<List<UserResponsePhotosDTO>, List<UserPhotosData>> {

    override fun map(response: List<UserResponsePhotosDTO>): List<UserPhotosData> =
        response.map { UserPhotosData(it.albumId, it.id, it.title, it.url, it.thumbnailUrl) }

    override fun getApiResponseType(): Class<List<UserResponsePhotosDTO>> =
        listOf<UserResponsePhotosDTO>().javaClass
}