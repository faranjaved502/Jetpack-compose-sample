package com.faran.jetpackapp.core.network.mapper

import com.faran.jetpackapp.core.domain.Error
import okhttp3.ResponseBody

interface ErrorMapper {

    fun map(response: ResponseBody) : Error

    fun getApiResponseType() : Class<ResponseBody>
}