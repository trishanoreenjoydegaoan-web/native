package com.example.myunscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                GameScreen()
            }
        }
    }
}

@Composable
fun UnscrambleTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}

@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel(),
) {
    // Connect StateFlow → Compose State — UI auto-updates
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        // Show scrambled word from UI State
        Text(
            text = uiState.scrambledWord,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        // TextField reads from UI State (typing not hooked up yet)
        OutlinedTextField(
            value = uiState.userAnswer,
            onValueChange = {},
            label = { Text("Enter your answer") }
        )

        Button(
            onClick = {}
        ) {
            Text("SUBMIT")
        }

        // Show score from UI State
        Text(
            text = "Score: ${uiState.score}"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}