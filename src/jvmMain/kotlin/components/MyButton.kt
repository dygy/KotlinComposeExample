package components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun MyButton(string: String, enabled: Boolean, setValue: () -> Unit) {
    Button(
        setValue,
        colors = when (enabled) {
            true -> ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Yellow)
            false -> ButtonDefaults.outlinedButtonColors(backgroundColor = Color.LightGray, contentColor = Color.Yellow)
        }
    ) {
        Text(string)
    }
}