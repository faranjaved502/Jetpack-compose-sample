package com.faran.jetpackapp.presentation.userDetails

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.faran.jetpackapp.data.user.domain.UserPhotosData
import com.faran.jetpackapp.presentation.utils.LoadingAnimation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailListItem(userPhotosData: UserPhotosData, onItemClick: (Int) -> Unit) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(180.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        onClick = { onItemClick(userPhotosData.id) }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFFF518A0),
                            Color(0xFFB232BD)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val painter =
                    rememberAsyncImagePainter(model = userPhotosData.thumbnailUrl)
                val state = painter.state

                if (state is AsyncImagePainter.State.Loading) {
                    LoadingAnimation()
                }
                val transition by animateFloatAsState(
                    targetValue = if (state is AsyncImagePainter.State.Success) 1f else 0f
                )

                Image(
                    painter = painter,
                    contentDescription = userPhotosData.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(100.dp)
                        .height(150.dp)
                        .alpha(transition)
                )

                Text(
                    modifier = Modifier.padding(10.dp),
                    text = userPhotosData.title,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}