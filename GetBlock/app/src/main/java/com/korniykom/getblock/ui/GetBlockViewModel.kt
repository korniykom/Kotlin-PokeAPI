package com.korniykom.getblock.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class GetBlockViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GetBlockUiState())
    val uiState: StateFlow<GetBlockUiState> = _uiState.asStateFlow()

    fun updateSearchQuery(text: String) {
        _uiState.update { currentState ->
            currentState.copy(searchQuery = text)
        }
    }
}