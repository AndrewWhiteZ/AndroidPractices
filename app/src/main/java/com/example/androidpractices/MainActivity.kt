package com.example.androidpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidpractices.components.BottomNavigationBar
import com.example.androidpractices.components.navigationItems
import com.example.androidpractices.screens.FavoriteScreen
import com.example.androidpractices.screens.ListScreen
import com.example.androidpractices.screens.MainScreen
import com.example.androidpractices.screens.PokemonScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val controller = rememberNavController()
    var currentRoute by remember { mutableStateOf("home") }

    Scaffold(
        bottomBar = { BottomNavigationBar(controller, currentRoute) { currentRoute = it } }
    ) { padding ->
        NavHost(navController = controller, startDestination = navigationItems.first().route) {
            composable("main") {
                currentRoute = "main"
                MainScreen()
            }
            composable("favorite") {
                currentRoute = "favorite"
                FavoriteScreen()
            }
            composable("list") {
                currentRoute = "list"
                ListScreen(controller)
            }
            composable("element/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                currentRoute = "element"
                PokemonScreen(controller, id)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen()
}
