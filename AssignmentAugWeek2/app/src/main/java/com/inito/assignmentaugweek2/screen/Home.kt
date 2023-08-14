package com.inito.assignmentaugweek2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    userInfo: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFF64B5F6), Color(0xFF1976D2), Color(0xFF0D47A1)),
                    radius = 800f
                )
            )
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                UserInfoTextField("Name:", userInfo[0])
                UserInfoTextField("Email:", userInfo[1])
                UserInfoTextField("Phone:", userInfo[2])
                UserInfoTextField("Password:", userInfo[3])
            }
        }
    }
}

@Composable
private fun UserInfoTextField(label: String, value: String) {
    Row {
        Text(
            text = label,
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth(),
            color = Color.DarkGray,
            textAlign = TextAlign.End
        )
    }

    Spacer(modifier = Modifier.height(8.dp))
}

@Preview
@Composable
fun HomePreview() {
    Home(listOf("ved", "@.com", "1234567890", "Ved@123"))
}