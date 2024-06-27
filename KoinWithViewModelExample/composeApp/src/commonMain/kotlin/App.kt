import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import ui.MainViewModel

@Composable
@Preview
fun App() {



    MaterialTheme {
        KoinContext {

            val mainViewModel = koinInject<MainViewModel>()
            val timer by mainViewModel.timer.collectAsState(0)

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Timer: $timer",
                    style = MaterialTheme.typography.h4
                )
            }
        }
    }
}