package com.faran.jetpackapp.presentation.userDetails

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.faran.jetpackapp.presentation.components.CircularProgressBar
import com.faran.jetpackapp.presentation.components.MyAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetail(
    navController: NavController,
    id: Int?,
    viewModel: UserDetailViewModel = hiltViewModel()
) {

    val list = viewModel.getUserPhotosList().collectAsState().value
    val status = viewModel.loadingState().collectAsState().value

    Scaffold(
        topBar = {
            MyAppBar(
                navController = navController, onBackPressed = {
                    navController.navigateUp()
                })
        }, content = { innerPadding ->
            CircularProgressBar(
                isDisplayed = status,
                modifier = Modifier.testTag("progress_bar")
            )
            LazyColumn(
                state = rememberLazyListState(),
                contentPadding = innerPadding
            ) {
                items(items = list) { photo ->
                    DetailListItem(photo, onItemClick = {
                    })
                }
            }
        }
    )
}