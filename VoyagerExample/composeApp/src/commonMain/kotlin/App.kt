import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.MainScreen

@Composable
fun App() {
    MaterialTheme {
//        Navigator(Wea1()){
//            SlideTransition(it)
//            //ScaleTransition(it)
//            //FadeTransition(it)
//        }
        Navigator(MainScreen()){
            SlideTransition(it)
        }
    }
}

class Wea1 : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { navigator?.push(Wea2()) }) {
                Text("Go to Screen 2")
            }
        }
    }
}

class Wea2 : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    navigator?.push(Wea3())
                }) {
                    Text("Go to Screen 3")
                }
                Button(onClick = {
                    navigator?.pop()
                }) {
                    Text("Go to Screen 1")
                }
            }
        }
    }
}

class Wea3 : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { navigator?.push(Wea1()) }) {
                Text("Go to Screen 1")
            }
        }
    }
}