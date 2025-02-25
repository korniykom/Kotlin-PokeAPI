package com.korniykom.pokeapi.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokeScreen(
    pokeViewModel: PokeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val pokeUiState by pokeViewModel.uiState.collectAsState()
    Text(
        text = pokeUiState.pokemon
    )
}