package expect

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.MainViewModel

actual val viewModelModule: Module = module {
    singleOf(::MainViewModel)
}