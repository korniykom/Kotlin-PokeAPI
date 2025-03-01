package com.korniykom.pokeapi.ui

import com.korniykom.pokeapi.model.Pokemon


data class PokeUiState(
    val pokemons: List<Pokemon> = listOf(),
    var isDropDownMenuOpen: Boolean = false,
    val sortOptions: List<String> = listOf(
        "Sort by Name", "Sort by Move", "Sort by Name Reverse", "Sort by Move Reverse"
    )

)