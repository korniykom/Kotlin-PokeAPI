package com.korniykom.pokeapi.ui

import ReloadButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.pokeapi.ui.components.PokeCard
import com.korniykom.pokeapi.ui.components.SortButton

@Composable
fun PokeScreen(
    pokeViewModel: PokeViewModel = viewModel(), modifier: Modifier = Modifier
) {

    val uiState by pokeViewModel.uiState.collectAsState();

    Column(
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFF1F1), Color(0xFFFFDCDC))

                )
            )
            .padding(top = 40.dp)
    ) {
        Column(
            modifier = modifier

                .weight(9.0f)
        ) {
            LazyRow(
                modifier = modifier.padding(start = 12.dp, bottom = 8.dp, end = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {
                items(items = uiState.sortOptions, itemContent = { item ->
                    when (item) {
                        "Sort by Name" -> {
                            SortButton(text = item, onClick = { pokeViewModel.sortByName() })
                        }

                        "Sort by Move" -> {
                            SortButton(text = item, onClick = { pokeViewModel.sortByMove() })
                        }

                        "Sort by Name Reverse" -> {
                            SortButton(text = item, onClick = { pokeViewModel.sortByNameReverse() })
                        }

                        "Sort by Move Reverse" -> {
                            SortButton(text = item, onClick = { pokeViewModel.sortByMoveReverse() })
                        }

                        else -> {
                            SortButton(onClick = {})
                        }
                    }
                })
            }

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(uiState.pokemons) { pokemon ->
                    PokeCard(pokemon)
                }
            }


        }

        ReloadButton(modifier = modifier, onClick = { pokeViewModel.fetchPokemons() })
    }
}
