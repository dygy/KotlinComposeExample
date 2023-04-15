package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.LineSubstring

@Preview
@Composable
fun MyCard() {
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
            MyButton("Click me")
            MyTable(
                modifier = Modifier.fillMaxHeight().padding(6.dp),
                columnCount = 3,
                rowCount = 10,
                cellContent = { columnIndex, rowIndex ->
                    MyText(" Column: $columnIndex - Row: $rowIndex ")
                })
        }
    }
}
