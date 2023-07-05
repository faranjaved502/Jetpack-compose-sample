package com.faran.jetpackapp.presentation.userDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.faran.jetpackapp.presentation.components.MyAppBar
import com.faran.jetpackapp.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetail(
    navController: NavController,
    id: Int?,
    viewModel: UserDetailViewModel = hiltViewModel()
) {

    id?.let { viewModel.getUserPhotos(it) }
    val list = viewModel.getUserPhotosList().collectAsState().value

    Scaffold(
        topBar = {
            MyAppBar(
                navController = navController, onBackPressed = {
                    navController.navigateUp()
                })
        }, content = { innerPadding ->
            LazyColumn(
                state = rememberLazyListState(),
                contentPadding = innerPadding
            ) {
                items(items = list) { photo ->
                    DetailListItem(photo, onItemClick = {
                        navController.navigate(Screens.PHOTO.withArgs(it.toString()))
                    })
                }
            }
        }
    )

}