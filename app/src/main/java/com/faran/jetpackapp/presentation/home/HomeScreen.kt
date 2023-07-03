package com.faran.jetpackapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.faran.jetpackapp.presentation.home.view.UserListItem
import com.faran.jetpackapp.presentation.navigation.Screens

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val list = viewModel.getUserList().collectAsState().value
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
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
                        text = "Home",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }, content = { innerPadding ->
            LazyColumn(
                state = rememberLazyListState(),
                contentPadding = innerPadding
            ) {
                items(items = list) { userData ->
                    UserListItem(userData, onItemClick = {
                        navController.navigate(Screens.UserDetail.withArgs(it))
                    })
                }
            }
        }
    )
}