package com.inito.bottomnavigationbar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.inito.bottomnavigationbar.InfoBottomBar

@Composable
fun SettingsScreen(navController: NavHostController) {
    InfoBottomBar(navController = navController) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "MySettings")
        }
    }
}