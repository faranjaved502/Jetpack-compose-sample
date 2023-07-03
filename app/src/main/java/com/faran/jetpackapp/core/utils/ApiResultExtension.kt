package com.faran.jetpackapp.core.utils

import com.faran.jetpackapp.core.domain.ApiResult


fun ApiResult<*>.isError(): Boolean {
    return error != null
}

fun ApiResult<*>.isSuccess(): Boolean {
    return !isError()
}