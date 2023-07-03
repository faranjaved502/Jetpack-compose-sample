package com.faran.jetpackapp.configuration

interface ConfigurationSettings {

    companion object {
        const val USER_BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    fun getUserBaseUrl(): String = USER_BASE_URL
}