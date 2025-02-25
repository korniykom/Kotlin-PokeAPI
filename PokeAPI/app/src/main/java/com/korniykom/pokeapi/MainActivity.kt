package com.korniykom.pokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.korniykom.pokeapi.ui.PokeScreen
import com.korniykom.pokeapi.ui.theme.PokeAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeAPITheme {
                PokeScreen()
            }
        }
    }
}
