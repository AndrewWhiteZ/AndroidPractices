package com.example.androidpractices.viewModels

import androidx.lifecycle.ViewModel
import com.example.androidpractices.domain.data.PokemonRepository
import com.example.androidpractices.domain.model.Pokemon

class PokemonViewModels: ViewModel() {
    private val repository: PokemonRepository = PokemonRepository()

    val pokemons: List<Pokemon> = getAll()

    fun getById(id: Int): Pokemon {
        return repository.getById(id)
    }

    fun getByName(name: String): Pokemon {
        return repository.getByName(name)
    }

    fun getAll(): List<Pokemon> {
        return repository.getAll()
    }

}