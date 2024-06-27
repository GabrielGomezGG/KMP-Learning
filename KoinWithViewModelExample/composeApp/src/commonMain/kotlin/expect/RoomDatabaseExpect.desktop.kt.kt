package expect

import data.local.AppDatabase

expect class RoomDatabaseExpect {
    fun getAppDatabase(): AppDatabase
}