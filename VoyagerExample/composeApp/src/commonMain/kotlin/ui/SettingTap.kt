package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.russhwolf.settings.Settings
import ui.components.TextWithSwitch

object SettingTap : Tab {

//    companion object {
//        const val DARK_MODE = "DARK_MODE"
//    }

    private val settings : Settings = Settings()

    @Composable
    override fun Content() {

        var darkMode by remember {
            mutableStateOf(settings.getBoolean("DARK_MODE", false))
        }

//        var checked by remember { mutableStateOf(true) }

        Box(
            Modifier.fillMaxSize()
                .background(Color(0xFFe165f7)),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text("Dark Mode", fontSize = 20.sp)
                Switch(
                    checked = darkMode,
                    onCheckedChange = {
                        darkMode = it
                        settings.putBoolean("DARK_MODE", it)
                    },
                )
            }

        }
    }

    override val options: TabOptions
        @Composable
        get(){
            val icon = rememberVectorPainter(Icons.Default.Settings)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Setting",
                    icon = icon
                )
            }
        }
}