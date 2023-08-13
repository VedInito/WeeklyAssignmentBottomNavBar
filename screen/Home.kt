package com.inito.assignmentaugweek2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home(
    userInfo: List<String>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val name = userInfo[0]
        val email = userInfo[1]
        val phone = userInfo[2]
        val password = userInfo[3]

        Text("Name: $name")
        Text("Email : $email")
        Text("Phone : $phone")
        Text("Password : $password")
    }
}

