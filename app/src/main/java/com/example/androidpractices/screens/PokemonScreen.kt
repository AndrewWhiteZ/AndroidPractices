package com.example.androidpractices.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidpractices.viewModels.PokemonViewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun PokemonScreen(controller: NavHostController, id: Int) {
    val viewModel = viewModel<PokemonViewModels>()
    val pokemon = viewModel.getById(id)

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = pokemon.name, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp))
        HorizontalDivider(thickness = 2.dp)
        Text(text = "Высота: " + pokemon.height, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Вес: " + pokemon.weight, style = MaterialTheme.typography.bodyLarge)
        HorizontalDivider(thickness = 2.dp)

        pokemon.items.forEach {
            ItemCard(it.name)
        }
    }
}

@Composable
fun ItemCard(name: String) {
    Card(modifier = Modifier.padding(0.dp, 6.dp, 0.dp, 0.dp)) {
        Text(
            text = name,
            modifier = Modifier.padding(8.dp, 5.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
