package com.example.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.data.Screen
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.Profile.name) {
                    composable(Screen.Profile.name) { MainScreen(navController) }
                    composable(Screen.FriendList.name) { FriendListScreen(navController) }
                }
            }
        }
    }
}
