package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*

@Preview
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