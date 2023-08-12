package com.inito.bottomnavigationbar

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inito.bottomnavigationbar.bottom_navigation.BottomNavItem
import com.inito.bottomnavigationbar.bottom_navigation.BottomNavigationBar
import com.inito.bottomnavigationbar.screens.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoBottomBar(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
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
                navController = navController,
                onItemClick = { navController.navigate(it.route) }
            )
        }
    ) {
        content()
    }
}
