package com.korniykom.pokeapi.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val uiState by pokeViewModel.uiState.collectAsState();

    val pokemons = uiState.pokemons
    Column {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            modifier = modifier.padding(horizontal = 12.dp)
        ) {
            items(pokemons) { pokemon ->
                PokeCard(pokemon)
            }
        }
        Spacer(modifier =modifier.weight(1.0f))
        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
           colors = ButtonDefaults.buttonColors(Color.Red),
            onClick = { pokeViewModel.fetchPokemons() }

        ) {
            Text(
                text = "Reload pokemons!",

                )
        }
    }
}

@Composable
fun PokeCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(pokemon.picture)
            .build()
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {

        Image (
            painter = painter,
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(120.dp)
        )
        Text(text = pokemon.name)

    }
}