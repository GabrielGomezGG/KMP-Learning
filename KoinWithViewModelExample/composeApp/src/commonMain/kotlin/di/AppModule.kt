package di

import data.TodoRepository
import org.koin.dsl.module

fun appModule() = module {

    single { TodoRepository(get())}
}