package expect

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.local.AppDatabase
import java.io.File

actual class RoomDatabaseExpect {
    actual fun getAppDatabase(): AppDatabase {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "app_database.db")
        return Room
            .databaseBuilder<AppDatabase>(
                name = dbFile.absolutePath,
            )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}