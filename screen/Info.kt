package com.inito.assignmentaugweek2.screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.inito.assignmentaugweek2.utility.bottom_navigation.BottomNavBar
import com.inito.assignmentaugweek2.utility.bottom_navigation.BottomNavItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Info(userInfo: List<String>) {
    var currentScreenRoute by rememberSaveable { mutableStateOf(Screen.Home.route) }
    var previousScreenRoute by rememberSaveable { mutableStateOf(Screen.Home.route) }
    Scaffold(
        bottomBar = {
            BottomNavBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = Screen.Home.route,
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = Screen.Chat.route,
                        icon = Icons.Default.Notifications
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = Screen.Settings.route,
                        icon = Icons.Default.Settings
                    )
                ),
                onItemClick = {
                    previousScreenRoute = currentScreenRoute
                    currentScreenRoute = it.route
                },
                modifier = Modifier,
                selectedItemRoute = currentScreenRoute
            )
        }
    ) {
        AnimatedContent(targetState = currentScreenRoute, label = "", transitionSpec = {
            val index =
                mapOf(Screen.Home.route to 0, Screen.Chat.route to 1, Screen.Settings.route to 2)
            val toMoveRight = (index[currentScreenRoute]?:0) - (index[previousScreenRoute]?:0) > 0
            slideInHorizontally(
                initialOffsetX = { initial ->
                    if (toMoveRight) +initial else -initial
                },
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { target ->
                    if (toMoveRight) -target else +target
                },
            )
        }) {
            when (it) {
                Screen.Home.route -> Home(userInfo)
                Screen.Chat.route -> Chat()
                Screen.Settings.route -> Settings()
            }
        }
    }
}