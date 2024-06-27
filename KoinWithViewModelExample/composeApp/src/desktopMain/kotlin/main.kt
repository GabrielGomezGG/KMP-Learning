import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import expect.KoinInitializer

fun main() = application {

    KoinInitializer().initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "KoinWithViewModelExample",
    ) {
        App()
    }
}