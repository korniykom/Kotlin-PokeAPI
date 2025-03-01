package com.korniykom.pokeapi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.korniykom.pokeapi.R
import com.korniykom.pokeapi.model.Pokemon

@Composable
fun PokeCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(pokemon.picture).build()
    )
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = modifier
            .padding(8.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .border(1.dp, colorResource(id = R.color.red_2), RoundedCornerShape(16.dp))


    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier

                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.red_1_light), colorResource(R.color.red_2_light)
                        )
                    )
                )
                .fillMaxSize()
                .padding(8.dp)
        ) {

            Image(
                painter = painter,
                contentDescription = pokemon.name,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(100.dp)
            )
            Text(text = pokemon.name, color = Color.White, fontWeight = FontWeight.Bold)
            Text(
                text = "Move 1: ${pokemon.moves[0].capitalize()}",
                fontSize = 8.sp,

                color = Color.White
            )
            Text(
                text = "Move 2: ${pokemon.moves[1].capitalize()}",
                fontSize = 8.sp,
                color = Color.White
            )
        }
    }
}