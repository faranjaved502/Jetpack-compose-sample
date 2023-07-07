package com.faran.jetpackapp.domain.entities.user

data class UserPhotosData(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)
