package com.example.androidpractices.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FavoriteScreen() {
    Text(text = "This is the Favorite screen, here you can find Pokemons, that you marked as a favorite!", style = MaterialTheme.typography.titleLarge)
}
