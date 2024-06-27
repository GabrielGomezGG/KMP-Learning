import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.getTodoDatabase
import di.appModule
import expect.KoinInitializer
import expect.viewModelModule
import org.koin.core.context.startKoin

fun main() = application {

    KoinInitializer().initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "KoinWithViewModelExample",
    ) {
        App()
    }
}