package expect

import android.content.Context
import di.appModule
import di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun initKoin() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(appModule(), viewModelModule, databaseModule())
        }
    }
}