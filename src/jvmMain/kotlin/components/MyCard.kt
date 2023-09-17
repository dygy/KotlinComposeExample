package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.LineSubstring

@Preview
@Composable
fun MyCard() {
    var isEnabled by remember { mutableStateOf(true) };
    var buttonText by remember { mutableStateOf("Show image") }
    val setValue = {
        println(isEnabled)
        isEnabled = !isEnabled
        buttonText = when (isEnabled) {
            true -> "Show image"
            false -> "Show table"
        }
    }
    Card(
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            MyLine(
                arrayOf<LineSubstring>(
                    LineSubstring("Welcome to"),
                    LineSubstring(
                        "Jetpack Compose Playground",
                        FontWeight.W900,
                        Color.Cyan
                    ),
                    LineSubstring("Now you are in the"),
                    LineSubstring("Card", FontWeight.W900, Color.Green),
                    LineSubstring("Section")
                )
            )
            MyButton(buttonText, setValue = setValue, enabled = isEnabled)
            when (isEnabled) {
                true -> MyTable(
                    modifier = Modifier.fillMaxHeight().padding(6.dp),
                    columnCount = 3,
                    rowCount = 10,
                    cellContent = { columnIndex, rowIndex ->
                        MyText(" Column: $columnIndex - Row: $rowIndex ")
                    }
                )

                false -> Image(
                    painter = painterResource("/drawable/download.jpeg"),
                    contentDescription = "dog",
                    modifier = Modifier.fillMaxSize()
                )
            }


        }
    }
}
