package com.korniykom.pokeapi.ui

import com.korniykom.pokeapi.model.Pokemon


data class PokeUiState(
    val pokemons: List<Pokemon> = listOf(Pokemon(name = "pokemon", picture = "url")),
    val isFetchSuccessful: Boolean = false,

    )