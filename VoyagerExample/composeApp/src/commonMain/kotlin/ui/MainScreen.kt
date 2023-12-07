package ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class MainScreen : Screen {
    @OptIn(ExperimentalVoyagerApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val tapList = listOf(HomeTap, FavTap, SettingTap)

        TabNavigator(
            HomeTap,
            tabDisposable = {
                TabDisposable(
                    it,
                    tapList
                )
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(it.current.options.title) })
                },
                bottomBar = {
                    BottomNavigation {
                        val tabNavigator = LocalTabNavigator.current

                        tapList.forEach {
                            BottomNavigationItem(
                                selected = tabNavigator.current.key == it.key,
                                label = { Text(it.options.title) },
                                icon = {
                                    Icon(
                                        painter = it.options.icon!!,
                                        contentDescription = null
                                    )
                                },
                                onClick = { tabNavigator.current = it }
                            )
                        }
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }
}