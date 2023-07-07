package com.faran.jetpackapp.presentation.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home")
    object UserDetail: Screens("user_detail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}