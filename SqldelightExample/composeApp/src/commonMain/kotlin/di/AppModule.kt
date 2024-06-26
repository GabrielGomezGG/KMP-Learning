package di

import androidx.lifecycle.viewmodel.compose.viewModel
import data.UserDao
import org.koin.dsl.module
import ui.MainViewModel

fun appModule() = module {

    single { UserDao(get()) }

    single { MainViewModel() }

}