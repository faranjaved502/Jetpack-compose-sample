package com.faran.jetpackapp.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.faran.jetpackapp.presentation.home.HomeScreen
import com.faran.jetpackapp.presentation.userDetails.UserDetail

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    )
    {
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = Screens.UserDetail.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ) { entry ->
            /* Extracting the id from the route */
            val id = entry.arguments?.getInt("id")
            UserDetail(
                navController = navController,
                id = id
            )
        }
    }
}