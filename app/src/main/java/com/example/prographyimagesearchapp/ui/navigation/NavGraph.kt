package com.example.prographyimagesearchapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.prographyimagesearchapp.ui.detail.DetailScreen
import com.example.prographyimagesearchapp.ui.home.HomeScreen
import com.example.prographyimagesearchapp.ui.randomphoto.RandomPhotoScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Random.route
        ) {
            RandomPhotoScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getString("itemId")
            DetailScreen(id = itemId ?: "", navController = navController)
        }
    }
}