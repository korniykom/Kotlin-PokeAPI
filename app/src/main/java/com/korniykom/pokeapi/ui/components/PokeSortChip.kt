package com.korniykom.pokeapi.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.korniykom.pokeapi.ui.theme.PokedexTypography


@Composable
fun PokeSortChip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val containerColor = if(isSelected) {
        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f)
    } else {
        MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
    }

    val textColor = if(isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    val borderColor = if(isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
    }

    Box(
        modifier = modifier
            .padding(8.dp)
            .then(
                if(isSelected) {
                    Modifier.shadow(
                        elevation = 6.dp,
                        shape = CircleShape
                    )
                } else Modifier.shadow(
                    elevation = 2.dp,
                    shape = CircleShape
                )
            )
            .clip(CircleShape)
            .border(
                width = if(isSelected) 1.5.dp else 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .background(containerColor)
            .clickable{
                onClick()
                isSelected = !isSelected
            }
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = PokedexTypography.pokemonType,
                color = textColor
            )
            AnimatedVisibility(
                visible = isSelected
            ) {
                IconButton(
                    onClick = {
                        onClick()
                        isSelected = !isSelected
                    },
                    modifier = Modifier
                        .size(20.dp)
                        .padding(start = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear button",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun PokeSortChipPreview() {
    MaterialTheme(){
        PokeSortChip(
            onClick = {},
            text = "Test chip",
        )
    }
}