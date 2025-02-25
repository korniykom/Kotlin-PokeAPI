package com.korniykom.pokeapi.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.pokeapi.network.PokeApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException


class PokeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PokeUiState())
    val uiState: StateFlow<PokeUiState> =_uiState.asStateFlow()



}