package components

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun MyText(text: String, weight: FontWeight = FontWeight.Medium, color: Color = Color.White) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontWeight = weight,
                color = color
            )) {
                append(text)
            }
        }
    )
}