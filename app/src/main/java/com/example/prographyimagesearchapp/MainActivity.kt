package com.example.prographyimagesearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.prographyimagesearchapp.ui.navigation.BottomNavigationBar
import com.example.prographyimagesearchapp.ui.navigation.NavGraph
import com.example.prographyimagesearchapp.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            AppTheme {
                Scaffold(
                    contentColor = MaterialTheme.colorScheme.surface,
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}