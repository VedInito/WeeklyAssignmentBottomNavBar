package com.inito.assignmentaugweek2.bottom_navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavBar(
    modifier: Modifier,
    items: List<BottomNavItem>,
    selectedItemRoute: String,
    onItemClick: (BottomNavItem) -> Unit
) {
    BottomNavigation(
        modifier = modifier, backgroundColor = Color.DarkGray, elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == selectedItemRoute
            BottomNavigationItem(selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                        if (selected)
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                    }
                }

            )
        }
    }
}