package com.korniykom.pokeapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.korniykom.pokeapi.model.Pokemon

@Composable
fun PokeScreen(
    pokeViewModel: PokeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val pokemons = listOf(
        Pokemon(
            name = "Bulbasaur",
            picture = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        ),
        Pokemon(
            name = "Ivysaur",
            picture = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"
        ),
        Pokemon(
            name = "Venusaur",
            picture = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"
        ),
        Pokemon(
            name = "Charmander",
            picture = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"
        ),
        Pokemon(
            name = "Charmeleon",
            picture = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/2.png"
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp)
    ) {
        items(pokemons) { pokemon ->
            PokeCard(pokemon)
        }
    }
}

@Composable
fun PokeCard(pokemon: Pokemon) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(pokemon.picture)
            .build()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {

        Image (
            painter = painter,
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(120.dp)
        )
        Text(text = pokemon.name)
    }
}