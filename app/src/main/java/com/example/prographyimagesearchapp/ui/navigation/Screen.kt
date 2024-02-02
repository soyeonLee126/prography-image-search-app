package com.example.prographyimagesearchapp.ui.navigation

import androidx.compose.material.icons.Icons
import com.example.prographyimagesearchapp.R

sealed class Screen(val route: String, val icon: Int, val label: String) {
    object Home : Screen("home", R.drawable.icon_home, "Home")
    object Random : Screen("random", R.drawable.icon_random, "Random")
}

