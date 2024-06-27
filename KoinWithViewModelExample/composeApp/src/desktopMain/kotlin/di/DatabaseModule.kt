package di

import expect.RoomDatabaseExpect
import org.koin.dsl.module

fun databaseModule() = module {
    single { RoomDatabaseExpect().getAppDatabase().getDao() }
}