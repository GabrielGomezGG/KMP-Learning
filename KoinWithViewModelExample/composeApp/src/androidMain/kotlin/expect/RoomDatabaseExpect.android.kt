package expect

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.local.AppDatabase

actual class RoomDatabaseExpect (
    private val context: Context
) {
    actual fun getAppDatabase(): AppDatabase {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("app_database.db")
        return Room
            .databaseBuilder<AppDatabase>(
                context = appContext,
                name = dbFile.absolutePath
            )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}