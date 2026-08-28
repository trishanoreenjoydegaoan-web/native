package com.example.myunscramble

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {
    // Word list — game data belongs in ViewModel
    val words = listOf(
        "CAT",
        "DOG",
        "BOOK",
    )

    // Internal mutable state — private so UI can't change directly
    private val _uiState = MutableStateFlow(
        GameUiState(
            scrambledWord = words[0]
                .toList()
                .shuffled()
                .joinToString("")
        )
    )

    // Expose read-only state to UI
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
}