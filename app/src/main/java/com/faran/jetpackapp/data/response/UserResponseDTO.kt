package com.faran.jetpackapp.data.response

import com.squareup.moshi.Json

data class UserResponseDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "username") val userName: String,
    @Json(name = "email") val email: String,
    @Json(name = "address") val address: Address,
    @Json(name = "phone") val phone: String,
    @Json(name = "website") val website: String,
    @Json(name = "company") val company: Company
)

data class Address(
    @Json(name = "street") val street: String,
    @Json(name = "suite") val suite: String,
    @Json(name = "city") val city: String,
    @Json(name = "zipcode") val zipcode: String,
    @Json(name = "geo") val geo: Geo,
)

data class Geo(
    @Json(name = "lat") val lat: String,
    @Json(name = "lng") val lng: String,
)

data class Company(
    @Json(name = "name") val name: String,
    @Json(name = "catchPhrase") val catchPhrase: String,
    @Json(name = "bs") val bs: String,
)