package com.example.myunscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myunscramble.ui.theme.MyUnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUnscrambleTheme {
                GameScreen()
            }
        }
    }
}

@Composable
fun GameScreen() {
    // Step 2 — State variable to remember what the user types
    var userAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Text(
            text = "TAC",
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Unscramble the word!",
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Step 4 — Connect state to TextField
        OutlinedTextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            label = { Text("Enter your answer") },
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = { /* Does nothing yet — Phase 3 */ },
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text("SUBMIT", fontSize = 18.sp)
        }

        Text(
            text = "Score: 0",
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    MyUnscrambleTheme {
        GameScreen()
    }
}