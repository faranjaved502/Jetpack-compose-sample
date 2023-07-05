package com.faran.jetpackapp.presentation.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.DialogNavigator
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.faran.jetpackapp.R
import com.faran.jetpackapp.presentation.home.HomeScreen
import com.faran.jetpackapp.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    navController: NavController = rememberNavController(),
    onBackPressed: () -> Unit = { }
) {

    val context = LocalContext.current
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val showBackButton by remember(currentBackStackEntry) {
        derivedStateOf {
            navController.previousBackStackEntry != null
        }
    }

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFF518A0),
                        Color(0xFFB232BD)
                    )
                )
            ),
        title = {
            Text(
                text = parseTitleFromRoute(currentBackStackEntry?.destination?.route.toString()),
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon =
        {
            if (showBackButton) {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        Icons.Filled.ArrowBack, "backIcon"
                    )
                }
            } else {
                null
            }
        }
    )
}

private fun getTitleForScreen(destination: String): String {
    return when (destination) {
        Screens.Home.route -> "Home"
        Screens.UserDetail.route -> "Details"
        Screens.PHOTO.route -> "Photo"
        else -> ""
    }
}

fun parseTitleFromRoute(route: String): String {
    val routeParts = route.split("/")
    // Assuming the title is the last part of the route path
    val title = routeParts.firstOrNull()
    return getTitleForScreen(title.orEmpty())
}