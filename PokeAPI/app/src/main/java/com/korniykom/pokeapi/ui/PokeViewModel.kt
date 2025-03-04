package com.korniykom.pokeapi.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.pokeapi.data.PokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random

class PokeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PokeUiState())
    val uiState: StateFlow<PokeUiState> = _uiState.asStateFlow()

    private val pokeRepository = PokeRepository()

    fun fetchPokemons() {

        _uiState.update { currentState ->
            currentState.copy(
                pokemons = listOf()
            )
        }

        viewModelScope.launch {
            try {
                for (i: Int in 1..Random.nextInt(10, 16)) {

                    val fetchedPokemon = pokeRepository.fetchPokemon(Random.nextInt(1, 1024))

                    if (fetchedPokemon != null) {
                        _uiState.update { currentState ->
                            currentState.copy(
                                pokemons = currentState.pokemons + fetchedPokemon
                            )
                        }
                    }
                }

            } catch (e: IOException) {
                Log.e("PokeViewModel", "Network Error: ${e.message}")
            } catch (e: Exception) {
                Log.e("PokeViewModel", "Unexpected error: ${e.message}")
            }
        }

    }

    fun sortByName() {
        _uiState.update { currentState ->
            val sortedByNamePokemons = currentState.pokemons.sortedBy { it.name }
            currentState.copy(
                pokemons = sortedByNamePokemons
            )
        }
        cancelDropDownMenu()
    }

    fun sortByNameReverse() {
        _uiState.update { currentState ->
            val sortedByNamePokemons = currentState.pokemons.sortedByDescending { it.name }
            currentState.copy(
                pokemons = sortedByNamePokemons
            )
        }
        cancelDropDownMenu()
    }

    fun sortByMove() {
        _uiState.update { currentState ->
            val sortedByNamePokemons = currentState.pokemons.sortedBy { it.moves[0] }
            currentState.copy(
                pokemons = sortedByNamePokemons
            )
        }
        cancelDropDownMenu()
    }

    fun sortByMoveReverse() {
        _uiState.update { currentState ->
            val sortedByNamePokemons = currentState.pokemons.sortedByDescending { it.moves[0] }
            currentState.copy(
                pokemons = sortedByNamePokemons
            )
        }
        cancelDropDownMenu()
    }

    fun toggleDropDownMenu() {
        _uiState.update { currentState ->
            val updatedIsDropDownMenu = !currentState.isDropDownMenuOpen
            currentState.copy(
                isDropDownMenuOpen = updatedIsDropDownMenu
            )
        }
    }

    fun cancelDropDownMenu() {
        _uiState.update { currentState ->
            currentState.copy(
                isDropDownMenuOpen = false
            )
        }
    }

    init {
        fetchPokemons()
    }


}