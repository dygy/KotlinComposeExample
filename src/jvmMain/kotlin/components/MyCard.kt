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
import data.Line

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
            MyLine(arrayOf<Line>(
                Line("Welcome to"),
                Line(
                "Jetpack Compose Playground",
                FontWeight.W900,
                Color.Cyan
                ),
                Line("Now you are in the"),
                Line("Card", FontWeight.W900, Color.Green),
                Line("Section")
            ))
            MyButton()
        }
    }
}
