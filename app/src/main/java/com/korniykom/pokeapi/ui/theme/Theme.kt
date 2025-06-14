package com.korniykom.pokeapi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryVariant,
    onPrimaryContainer = DarkOnPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryVariant,
    onSecondaryContainer = DarkOnSecondary,
    tertiary = DarkAccent,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkTextSecondary,
    outline = DarkTextTertiary,
    outlineVariant = DarkTextTertiary.copy(alpha = 0.3f)
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryVariant,
    onPrimaryContainer = LightOnPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryVariant,
    onSecondaryContainer = LightOnSecondary,
    tertiary = LightAccent,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightTextSecondary,
    outline = LightTextTertiary,
    outlineVariant = LightTextTertiary.copy(alpha = 0.3f)
)


@Composable
fun PokeAPITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun backgroundGradient(): Brush {
    return if (isSystemInDarkTheme()) {
        Brush.verticalGradient(
            colors = listOf(
                DarkGradientStart,
                DarkGradientEnd
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                LightGradientStart,
                LightGradientEnd
            )
        )
    }
}

@Composable
fun cardGradient(): Brush {
    return if (isSystemInDarkTheme()) {
        Brush.verticalGradient(
            colors = listOf(
                DarkSurface,
                DarkSurfaceVariant.copy(alpha = 0.8f)
            )
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                LightSurface,
                LightSurfaceVariant.copy(alpha = 0.6f)
            )
        )
    }
}