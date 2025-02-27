package com.korniykom.getblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.korniykom.getblock.ui.HomeScreen
import com.korniykom.getblock.ui.theme.GetBlockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetBlockTheme {
                  HomeScreen()
            }
        }
    }
}

