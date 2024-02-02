package com.example.prographyimagesearchapp.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEach { screen ->
                IconButton(onClick = {
                    navController.navigate(screen.route)
                }) {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.label
                    )
                }
            }
        }
    }
}

val items = listOf(
    Screen.Home,
    Screen.Random
)
