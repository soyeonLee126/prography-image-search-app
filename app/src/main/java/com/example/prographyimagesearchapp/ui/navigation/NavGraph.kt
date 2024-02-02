package com.example.prographyimagesearchapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.prographyimagesearchapp.ui.home.HomeScreen
import com.example.prographyimagesearchapp.ui.randomphoto.RandomPhotoScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(
            route = Screen.Random.route
        ) { RandomPhotoScreen() }
    }
}