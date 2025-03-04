package com.korniykom.pokeapi.model

data class Pokemon(
    val name: String, val picture: String, val moves: List<String>
)

data class PokemonResponse(
    val name: String, val sprites: Sprites, val moves: List<MoveWrapper>
)

data class Sprites(
    val front_default: String
)

data class MoveWrapper(
    val move: Move
)

data class Move(
    val name: String
)