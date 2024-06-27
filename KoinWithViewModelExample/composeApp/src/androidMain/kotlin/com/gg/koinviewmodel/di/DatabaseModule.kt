package di

import android.content.Context
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import expect.RoomDatabaseExpect
import org.koin.androidx.compose.get

fun databaseModule() = module {
//    single { getTodoDatabase(get<Context>()).getDao() }
    single { RoomDatabaseExpect(get<Context>()).getAppDatabase().getDao() }
}