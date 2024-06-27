package di

import data.getTodoDatabase
import org.koin.dsl.module

fun databaseModule() = module {
    single { getTodoDatabase().getDao() }
}