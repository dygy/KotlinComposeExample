package components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import data.LineSubstring

@Composable
fun MyLine(strings: Array<LineSubstring>) {
    Text(
        buildAnnotatedString {
            for (lineElement in strings) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = lineElement.fontWeight,
                        color = lineElement.color
                    )
                ) {
                    append(lineElement.string)
                    append(" ")
                }
            }
        }
    )
}