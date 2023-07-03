package com.faran.jetpackapp.presentation.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object UserDetail: Screens("user_detail_screen")
    object PHOTO: Screens("photo_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}