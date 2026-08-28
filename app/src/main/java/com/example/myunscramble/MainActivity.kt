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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

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
fun GameScreen() {
    // --- Phase 2: State variable for user input ---
    var userAnswer by remember { mutableStateOf("") }

    // --- Phase 4 & 5: Word list, index, scrambled word ---
    val words = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )
    var currentWordIndex by remember { mutableStateOf(0) }
    val correctAnswer = words[currentWordIndex]
    var scrambledWord by remember {
        mutableStateOf(
            words[0].toList().shuffled().joinToString("")
        )
    }

    // --- Phase 3: Score state ---
    var score by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        // --- Phase 5: Show scrambled word instead of answer ---
        Text(
            text = scrambledWord,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        // --- Phase 2: Connect TextField to state ---
        OutlinedTextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            label = { Text("Enter your answer") }
        )

        // --- Phase 3 & 4: Check answer, update score & move to next word ---
        Button(
            onClick = {
                if (userAnswer.uppercase() == correctAnswer) {
                    score++
                    if (currentWordIndex < words.size - 1) {
                        currentWordIndex++
                        userAnswer = ""
                        scrambledWord = words[currentWordIndex]
                            .toList()
                            .shuffled()
                            .joinToString("")
                    }
                }
            }
        ) {
            Text("SUBMIT")
        }

        // --- Phase 3: Show live score ---
        Text(
            text = "Score: $score"
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