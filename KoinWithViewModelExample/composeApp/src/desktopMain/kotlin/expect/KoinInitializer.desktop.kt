package expect

import di.appModule
import di.databaseModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun initKoin() {
        startKoin {
            modules(appModule(), viewModelModule,databaseModule())
        }
    }
}