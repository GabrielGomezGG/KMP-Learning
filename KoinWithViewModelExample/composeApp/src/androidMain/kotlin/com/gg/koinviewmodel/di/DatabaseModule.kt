package di

import android.content.Context
import com.gg.koinviewmodel.data.getTodoDatabase
import org.koin.dsl.module

fun databaseModule() = module {
    single { getTodoDatabase(get<Context>()).getDao() }
}