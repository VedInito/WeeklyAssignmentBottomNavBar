package com.inito.bottomnavigationbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.inito.bottomnavigationbar.screens.Screen
import com.inito.bottomnavigationbar.screens.SignUpScreen


@Composable
fun Navigation() {
    var userInfo by remember { mutableStateOf(List(4) { " " }) }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignUp.route) {
        composable(route = Screen.SignUp.route) {
            Screen.SignUp.Display(navController = navController)
            SignUpScreen(navController = navController, updateUserInfo = { userInfo = it })
        }

        composable(route = Screen.Home.route) {
            Screen.Home.Display(navController, userInfo = userInfo)
        }
        composable(route = Screen.Chat.route) {
            Screen.Chat.Display(navController)
        }
        composable(route = Screen.Settings.route) {
            Screen.Settings.Display(navController)
        }
    }
}
