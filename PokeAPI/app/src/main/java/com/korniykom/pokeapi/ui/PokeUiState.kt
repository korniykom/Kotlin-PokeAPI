package com.korniykom.pokeapi.ui

import com.korniykom.pokeapi.model.Pokemon


data class PokeUiState(
    val pokemons: List<Pokemon> = listOf(), var isDropDownMenuOpen: Boolean = false

)