package com.example.fashion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fashion.presentation.navigation.BottomNavigationItem
import com.example.fashion.presentation.screens.homeScreen.HomeScreen
import com.example.fashion.ui.theme.FashionTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            FashionTheme {
                val largeRadialGradient = object : ShaderBrush() {
                    override fun createShader(size: Size): Shader {
                        val biggerDimension = maxOf(size.height, size.width)
                        //                colors = listOf(Color(0xFF8B8480), Color(0xFF696364)),
                        return RadialGradientShader(
                            colors = listOf(Color(0xFFAAA7A4), Color(0xFF36323A)),
                            center = size.center,
                            radius = biggerDimension / 2f,
                            colorStops = listOf(0f, 0.95f),
                        )
                    }
                }

                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = painterResource(id = R.drawable.home_filled),
                        unselectedIcon = painterResource(id = R.drawable.home),
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Compass",
                        selectedIcon = painterResource(id = R.drawable.fill_compass),
                        unselectedIcon = painterResource(id = R.drawable.compass_fashion),
                        hasNews = false,
                        badgeCount = 45
                    ),
                    BottomNavigationItem(
                        title = "Chat",
                        selectedIcon = painterResource(id = R.drawable.fill_chat_fashion),
                        unselectedIcon = painterResource(id = R.drawable.chat_fashion),
                        hasNews = true,
                    ),
                    BottomNavigationItem(
                        title = "Chat",
                        selectedIcon = painterResource(id = R.drawable.fill_person),
                        unselectedIcon = painterResource(id = R.drawable.normal_person),
                        hasNews = false,
                        badgeCount = 45
                    ),

                    )
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }


                Scaffold(bottomBar = {

                    NavigationBar(
                        modifier = Modifier
                            .height(80.dp)
                            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                            .clip(CircleShape),
                        containerColor = Color.Black
                    ) {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = { selectedItemIndex = index },
                                icon = {
//                                    BadgedBox(
//
//                                        badge = {
//                                            if (item.badgeCount != null) {
//                                                Badge {
//                                                    Text(text = item.badgeCount.toString())
//                                                }
//                                            } else if (item.hasNews) {
//                                                Badge()
//                                            }
//                                        }
//                                    ) {

                                    Box(
                                        modifier = Modifier
                                            .size(50.dp)
                                            .background(
                                                if (selectedItemIndex == index) Color.White else Color.Transparent,
                                                CircleShape
                                            ), contentAlignment = Alignment.Center
                                    ) {

                                        Icon(
                                            painter = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title,
                                            modifier = Modifier.size(25.dp)
                                        )
                                    }

//                                         }
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.Transparent,
                                    selectedIconColor = Color.Black,
                                    unselectedIconColor = Color.Gray
                                )
                            )

                        }
                    }
                }) {

                    Column(
                        Modifier
                            .fillMaxSize()
                            .background(largeRadialGradient)
                            .padding(it)
                    ) {

                        HomeScreen()
                    }
                }
            }
        }
    }

}

