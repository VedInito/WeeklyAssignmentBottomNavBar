package com.inito.assignmentaugweek2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.inito.assignmentaugweek2.screen.Info
import com.inito.assignmentaugweek2.screen.Screen
import com.inito.assignmentaugweek2.screen.SignUp
import com.inito.assignmentaugweek2.viewmodel.ProductDataViewModel

@Composable
fun NavigationManager(
    productDataViewModel: ProductDataViewModel
) {
    val navController = rememberNavController()

    var userInfo by rememberSaveable { mutableStateOf(List(4) { "default" }) }

    NavHost(navController = navController, startDestination = Screen.SignUp.route) {
        composable(route = Screen.SignUp.route) {
            SignUp(navController = navController,
                updateUserInfo = { updatedUserInfo -> userInfo = updatedUserInfo })
        }

        composable(route = Screen.Info.route) {
            Info(
                productDataViewModel = productDataViewModel,
                userInfo = userInfo
            )
        }
    }
}