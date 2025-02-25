package com.korniykom.pokeapi.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.pokeapi.data.PokeRepository
import com.korniykom.pokeapi.model.Pokemon
import com.korniykom.pokeapi.network.PokeApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random


class PokeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PokeUiState())
    val uiState: StateFlow<PokeUiState> =_uiState.asStateFlow()

    private val pokeRepository = PokeRepository()

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon: StateFlow<Pokemon?> get() = _pokemon

    fun fetchPokemon(id: Int) {
        viewModelScope.launch {
            try {
                val fetchedPokemon = pokeRepository.fetchPokemon(id)

                if(fetchedPokemon != null) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            pokemons = currentState.pokemons + fetchedPokemon
                        )
                    }
                }

            } catch (e: IOException) {
                Log.e("PokeViewModel", "Network Error: ${e.message}")
            } catch (e: Exception) {
                Log.e("PokeViewModel", "Unexpected error: ${e.message}")
            }
        }

    }

    init {
        fetchPokemon(Random.nextInt(1, 1025))
    }


}