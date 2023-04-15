package components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun MyButton() {
    var text by remember { mutableStateOf("Hello, World!") }

    Button(onClick = {
        text = "Hello, Desktop!"
    }) {
        Text(text)
    }
}