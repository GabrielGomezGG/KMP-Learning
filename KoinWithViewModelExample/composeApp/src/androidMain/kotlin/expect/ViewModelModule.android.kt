package expect

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import ui.MainViewModel

actual val viewModelModule: Module = module {
    viewModelOf(::MainViewModel)
}
