import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.MyCard

@Composable
@Preview
fun App() {
    MaterialTheme {
        MyCard()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DygyApp",
        resizable = true,
        icon = painterResource("drawable/logo.png"),
    ) {
        App()
    }
}
