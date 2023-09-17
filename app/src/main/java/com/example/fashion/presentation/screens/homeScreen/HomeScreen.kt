package com.example.fashion.presentation.screens.homeScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.fashion.R
import com.example.fashion.presentation.screens.homeScreen.composables.Post
import com.example.fashion.presentation.screens.homeScreen.uiState.HomeUiEvent
import com.example.fashion.presentation.screens.homeScreen.uiState.PostUiState
import com.example.fashion.ui.theme.SearchBarColor


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            //                colors = listOf(Color(0xFF8B8480), Color(0xFF696364)),
            return RadialGradientShader(
                colors = listOf(Color(0xFFAAA7A4), Color(0xFF504B4C)),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 0.95f),
            )
        }
    }


        Column(
            Modifier
                 .fillMaxSize()
            //  .background(largeRadialGradient)
        ) {

            val posts = listOf(
                PostUiState(
                    "Ahmed Khater",
                    "https://media.istockphoto.com/id/1229079874/video/i-just-cant-help-but-to-express-myself.jpg?s=640x640&k=20&c=hdWtqQx8Ghelbw6JIAMIXJ9_mqYq4Ums7SHCcYVUi70=",
                    "Android developer | kotlin",
                    "https://i.ibb.co/mhdXwWy/61661111-337753630240461-3665159281362480972-n.jpg"
                ),
                PostUiState(
                    "Moustafa Hamdi",
                    "https://images.squarespace-cdn.com/content/v1/572f75e77c65e4a1135a3266/1500055386885-9VI5BNQ5ZTL2FNMDGLF6/image-asset.jpeg?format=1500w",
                    "UI/UX Designer - New york",
                    "https://i.ibb.co/KWW5MQG/52971481-300810903936916-604048348145581331-n.jpg"
                ),
                PostUiState(
                    "Eslam",
                    "https://img.freepik.com/free-photo/worldface-ugandan-man-white-background_53876-14474.jpg",
                    "Fashionista - Cairo",
                    "https://i.ibb.co/b7v5zKq/55862938-2379960135569692-197893232071449665-n.jpg"
                ),
                PostUiState(
                    "Mohammed",
                    "https://wallpapercrafter.com/desktop2/807708-cillian-murphy-portrait-looking-at-camera-headshot.jpg",
                    "Teacher|Arabic - Cairo",
                    "https://i.ibb.co/0fYHjs1/56470491-310969112919229-7920098677381692782-n.jpg"
                ),
            )

            AnimatedVisibility(visible = !homeViewModel.postsUiState.isSearchBarActive)
            {
                Row(
                    Modifier

                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = "https://wallpapercrafter.com/desktop1/600887-Cristiano-Ronaldo-portrait-one-person-headshot.jpg",
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Black, CircleShape),
                        contentScale = ContentScale.Crop,

                        )

                    Text(
                        text = "Fashionista",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape)
                            .background(SearchBarColor)
                            .blur(30.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painterResource(id = R.drawable.notification),
                            contentDescription = "more",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )


                    }
                }
            }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            start = if (homeViewModel.postsUiState.isSearchBarActive) 0.dp else 10.dp,
                            end = if (homeViewModel.postsUiState.isSearchBarActive) 0.dp else 10.dp,
                            bottom = if (homeViewModel.postsUiState.isSearchBarActive) 0.dp else 20.dp
                        ),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val configuration = LocalConfiguration.current
                    val screenWidth = configuration.screenWidthDp.dp
                    val screenHeight = configuration.screenHeightDp.dp


                    val searchBarHeight by animateDpAsState(
                        if (homeViewModel.postsUiState.isSearchBarActive) screenHeight else 60.dp,
                        label = "searchBarHeight"
                    )

                    SearchBar(
                        modifier = Modifier
                            .weight(3f)
                            .align(CenterVertically),
                        query = homeViewModel.postsUiState.textSearch,
                        onQueryChange = { homeViewModel.onEvent(HomeUiEvent.SearchTextChanged(it)) },
                        onSearch = {
                            homeViewModel.onEvent(HomeUiEvent.Search)
                            homeViewModel.onEvent(HomeUiEvent.AddToHistory(it))
                        },
                        active = homeViewModel.postsUiState.isSearchBarActive,
                        onActiveChange = {
                            homeViewModel.onEvent(HomeUiEvent.SearchBarActive(it))
                        },
                        placeholder = {
                            Text(
                                text = "Search here...",
                                modifier = Modifier
                                    .requiredHeightIn(40.dp)
                                    .padding(top = 10.dp)
                            )
                        },

                        trailingIcon = {
                            if (homeViewModel.postsUiState.isSearchBarActive) {
                                Icon(
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .clickable {
                                            homeViewModel.onEvent(HomeUiEvent.ClearOrCloseSearchBar)
                                        },
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = "Close Icon"
                                )
                            }
                        },

                        colors = SearchBarDefaults.colors(
                            containerColor = SearchBarColor,
                        )
                    ) {
                        val context = LocalContext.current
                        homeViewModel.postsUiState.searchHistory.forEach {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 14.dp)
                                    .clickable {
                                        Toast
                                            .makeText(context, it, Toast.LENGTH_LONG)
                                            .show()
                                    }) {
                                Icon(
                                    modifier = Modifier.padding(end = 10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = "History Icon",
                                    tint = Color.White.copy(0.8f)
                                )
                                Text(text = it, color = MaterialTheme.colorScheme.onSurface)
                            }
                        }

                    }
                    AnimatedVisibility(
                        visible = !homeViewModel.postsUiState.isSearchBarActive,
                        modifier = Modifier

                    ) {

                        Box(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(SearchBarColor), contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier,
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "History Icon",
                                tint = Color.White.copy(0.8f)
                            )
                        }
                    }
                }





            LazyColumn(
                Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {


                items(posts) {
                    Post(post = it)
                }
            }

    }

}


