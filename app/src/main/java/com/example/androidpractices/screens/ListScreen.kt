package com.example.androidpractices.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.androidpractices.viewModels.PokemonViewModels

@Composable
fun ListScreen(controller: NavHostController) {
    val viewModel = viewModel<PokemonViewModels>()
    val pokemons = viewModel.pokemons

    LazyColumn (Modifier.fillMaxSize()) {
        items(pokemons) { pokemon ->
            ListItem(
                modifier = Modifier.clickable { controller.navigate("element/${pokemon.id}") },
                headlineContent = {
                    Card {
                        Text(text = "Pokemon: ${pokemon.name}", modifier = Modifier.padding(8.dp, 6.dp))
                    }
                }
            )
        }
    }
}
