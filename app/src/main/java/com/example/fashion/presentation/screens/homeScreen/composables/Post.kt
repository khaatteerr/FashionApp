package com.example.fashion.presentation.screens.homeScreen.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fashion.R
import com.example.fashion.presentation.screens.homeScreen.uiState.PostUiState
import com.example.fashion.ui.theme.BorderStroke

@Composable
fun Post(post: PostUiState) {

    Box(
        Modifier

            .fillMaxWidth(0.95f)
            .height(500.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(
                5.dp, brush = Brush.verticalGradient(
                    listOf(Black.copy(0.2f), Black.copy(0.4f)),
                    startY = 100f
                ), shape = RoundedCornerShape(30.dp)
            )
     ) {

        AsyncImage(
            model = post.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Black.copy(0.6f), Transparent, Black.copy(0.6f)),
                        startY = 50f
                    )
                )
        )

        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {


            Row(
                Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = post.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,

                    )
                Column {

                    Text(
                        text = post.userName,
                        fontWeight = Bold,
                        fontSize = 14.sp,
                        color = White,

                        )
                    Text(
                        text = post.jobInfo,
                        fontWeight = Light,
                        fontSize = 13.sp,
                        color = White,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))


                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(DarkGray.copy(0.8f))
                        .blur(30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "more",
                        modifier = Modifier.size(20.dp),
                        tint = White
                    )


                }


            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(DarkGray.copy(0.8f))
                        .blur(30.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painterResource(id = R.drawable.like_filled),
                        contentDescription = "like",
                        modifier = Modifier.size(25.dp),
                        tint = White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(DarkGray.copy(0.8f))
                        .blur(30.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painterResource(id = R.drawable.comment_threads),
                        contentDescription = "comment",
                        modifier = Modifier.size(25.dp),
                        tint = White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(DarkGray.copy(0.8f))
                        .blur(30.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painterResource(id = R.drawable.thunder),
                        contentDescription = "boost",
                        modifier = Modifier.size(25.dp),
                        tint = White
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(DarkGray.copy(0.8f))
                        .blur(30.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        painterResource(id = R.drawable.share),
                        contentDescription = "share",
                        modifier = Modifier.size(25.dp),
                        tint = White
                    )


                }


            }
        }


    }
}
