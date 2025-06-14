package com.korniykom.pokeapi.ui

import ReloadButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.pokeapi.ui.components.PokeCard
import com.korniykom.pokeapi.ui.components.PokeSortChip
import com.korniykom.pokeapi.ui.theme.backgroundGradient

@Composable
fun PokeScreen(
    modifier: Modifier = Modifier,
    pokeViewModel: PokeViewModel = viewModel()
) {
    val uiState by pokeViewModel.uiState.collectAsState();
    Column(
        modifier = modifier
            .background(
                brush = backgroundGradient()
            )
            .padding(top = 40.dp)
    ) {
        Column(
            modifier = modifier

                .weight(9.0f)
        ) {
            FlowRow (
                modifier = modifier.padding(start = 12.dp, bottom = 8.dp, end = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {
                uiState.sortOptions.map { item ->
                    when (item) {
                        "Sort by Name" -> {
                            PokeSortChip(
                                text = item,
                                onClick = { pokeViewModel.sortByName() },
                            )
                        }

                        "Sort by Move" -> {
                            PokeSortChip(
                                text = item,
                                onClick = { pokeViewModel.sortByMove() })
                        }

                        "Sort by Name Reverse" -> {
                            PokeSortChip(
                                text = item,
                                onClick = { pokeViewModel.sortByNameReverse() })
                        }

                        "Sort by Move Reverse" -> {
                            PokeSortChip(
                                text = item,
                                onClick = { pokeViewModel.sortByMoveReverse() })
                        }

                        else -> {
                            PokeSortChip(
                                onClick = {},
                                text = "Wrong chip"
                            )
                        }
                    }
                }
            }

            LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 180.dp)) {
                items(uiState.pokemons) { pokemon ->
                    PokeCard(pokemon)
                }
            }


        }

        ReloadButton(modifier = modifier, onClick = { pokeViewModel.fetchPokemons() })
    }
}
