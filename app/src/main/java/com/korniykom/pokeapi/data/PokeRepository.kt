package com.korniykom.pokeapi.data

import com.korniykom.pokeapi.domain.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokeRepository {
    suspend fun fetchPokemon(id: Int): Pokemon? {
        return withContext(Dispatchers.IO) {
            try {
                val response = PokeApi.retrofitService.getPokemon(id)
                val moves = response.moves.take(2).map { it.move.name }
                Pokemon(
                    name = response.name.capitalize(),
                    picture = response.sprites.front_default,
                    moves = moves
                )
            } catch (e: Exception) {
                null
            }
        }
    }
}