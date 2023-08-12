package com.inito.bottomnavigationbar.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    object SignUp : Screen("sign_up") {
        @Composable
        fun Display(navController: NavHostController) = SignUpScreen(navController = navController)
    }

    object Home : Screen("home") {
        @Composable
        fun Display(navController: NavHostController, userInfo: List<String>) = HomeScreen(navController, userInfo)
    }

    object Chat : Screen("chat") {
        @Composable
        fun Display(navController: NavHostController) = ChatScreen(navController)
    }

    object Settings : Screen("settings") {
        @Composable
        fun Display(navController: NavHostController) = SettingsScreen(navController)
    }
}
