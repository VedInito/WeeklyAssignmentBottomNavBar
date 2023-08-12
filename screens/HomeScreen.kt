package com.inito.bottomnavigationbar.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.inito.bottomnavigationbar.InfoBottomBar
import com.inito.bottomnavigationbar.bottom_navigation.BottomNavItem
import com.inito.bottomnavigationbar.bottom_navigation.BottomNavigationBar

@Composable
fun HomeScreen2(navController: NavHostController, list: List<String> = listOf()) {
    InfoBottomBar(navController = navController) {
        var name by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var phone by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        name = list[0]
        email = list[1]
        phone = list[2]
        password = list[3]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Name : $name")
                Text(text = "Email : $email")
                Text(text = "Phone : $phone")
                Text(text = "Password : $password")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController, list: List<String> = listOf()) {
    var currentScreen by rememberSaveable { mutableStateOf(Screen.Home.route) }

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
                onItemClick = {
                    currentScreen = it.route
                }
            )
        }
    ) {
        when (currentScreen) {
            Screen.Settings.route -> {
                Screen.Settings.Display(navController = navController)
            }
            Screen.Chat.route -> {
                Screen.Chat.Display(navController = navController)
            }
            else -> {
                var name by rememberSaveable { mutableStateOf("") }
                var email by rememberSaveable { mutableStateOf("") }
                var phone by rememberSaveable { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }

                name = list[0]
                email = list[1]
                phone = list[2]
                password = list[3]

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Name : $name")
                        Text(text = "Email : $email")
                        Text(text = "Phone : $phone")
                        Text(text = "Password : $password")
                    }
                }
            }
        }
    }
}
