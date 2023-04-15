package components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun MyButton(string: String) {
    var text by remember { mutableStateOf(string) }
    var enabled by remember {
        mutableStateOf(true)
    }

    val onClick = {
        text = "Pressed!"
        enabled = false
    }

    Button(
        onClick,
        enabled = enabled
    ) {
        Text(text)
    }
}