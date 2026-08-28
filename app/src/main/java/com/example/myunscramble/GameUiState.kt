package com.example.myunscramble

// Snapshot of everything the UI needs to display
data class GameUiState(
    val scrambledWord: String = "",
    val userAnswer: String = "",
    val score: Int = 0
)