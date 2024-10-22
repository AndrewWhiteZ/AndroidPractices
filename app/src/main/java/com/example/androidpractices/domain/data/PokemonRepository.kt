package com.example.androidpractices.domain.data

import android.content.res.Resources.NotFoundException
import com.example.androidpractices.domain.model.Item
import com.example.androidpractices.domain.model.Pokemon

class PokemonRepository {

    fun getById(id: Int) : Pokemon {
        return data.firstOrNull { it.id == id } ?: throw NotFoundException("Pokemon with Id «$id» not found")
    }

    fun getByName(name: String) : Pokemon {
        return data.firstOrNull { it.name == name } ?: throw NotFoundException("Pokemon with name «$name» not found")
    }

    fun getAll() : List<Pokemon> {
        return data
    }

    companion object {
        val data = listOf(
            Pokemon(132, "ditto", 3, 40, listOf(
                Item("metal-powder", "https://pokeapi.co/api/v2/item/234/"),
                Item("quick-powder", "https://pokeapi.co/api/v2/item/251/"),
            )),
            Pokemon(79, "slowpoke", 12, 360, listOf(
                Item("kings-rock", "https://pokeapi.co/api/v2/item/198/"),
                Item("lagging-tail", "https://pokeapi.co/api/v2/item/256/"),
            )),
            Pokemon(37, "vulpix", 6, 99, listOf(
                Item("rawst-berry", "https://pokeapi.co/api/v2/item/129/"),
                Item("charcoal", "https://pokeapi.co/api/v2/item/226/"),
            ))
        )
    }

}