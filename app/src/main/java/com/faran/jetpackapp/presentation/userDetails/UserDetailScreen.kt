package com.faran.jetpackapp.presentation.userDetails

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun UserDetail(navController: NavController, id: Int?) {

    val context = LocalContext.current
    Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()
}