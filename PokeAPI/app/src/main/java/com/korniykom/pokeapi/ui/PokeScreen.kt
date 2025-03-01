package com.korniykom.pokeapi.ui

import ReloadButton
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.korniykom.pokeapi.model.Pokemon
import com.korniykom.pokeapi.ui.components.PokeCard

@Composable
fun PokeScreen(
    pokeViewModel: PokeViewModel = viewModel(), modifier: Modifier = Modifier
) {

    val uiState by pokeViewModel.uiState.collectAsState();

    Column(modifier = modifier
        .background(
            Brush.verticalGradient(
            colors = listOf(Color(0xFFFFF1F1), Color(0xFFFFDCDC)) // Soft pink gradient
        )
        )) {
        Box(modifier = modifier.fillMaxWidth()) {
            IconButton(
                onClick = { pokeViewModel.toggleDropDownMenu() },
                modifier = modifier.align(Alignment.TopEnd)
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More options")
            }
            DropdownMenu(
                expanded = uiState.isDropDownMenuOpen,
                onDismissRequest = { pokeViewModel.cancelDropDownMenu() },
                modifier = modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth()


            ) {
                DropdownMenuItem(text = { Text("Sort by name") },
                    onClick = { pokeViewModel.sortByName() })
                DropdownMenuItem(text = { Text("Sort by name reverse") },
                    onClick = { pokeViewModel.sortByNameReverse() })
                DropdownMenuItem(text = { Text("Sort by move") },
                    onClick = { pokeViewModel.sortByMove() })
                DropdownMenuItem(text = { Text("Sort by move reverse") },
                    onClick = { pokeViewModel.sortByMoveReverse() })
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .padding(horizontal = 12.dp)
                .weight(9.0f)
        ) {
            items(uiState.pokemons) { pokemon ->
                PokeCard(pokemon)
            }
        }

       ReloadButton(
           modifier = modifier, onClick = { pokeViewModel.fetchPokemons() }
       )
    }
}
