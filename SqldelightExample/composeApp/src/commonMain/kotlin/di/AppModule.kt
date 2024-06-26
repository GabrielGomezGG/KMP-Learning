package di

import data.UserDao
import org.koin.dsl.module

fun appModule() = module {

    single { UserDao(get()) }

}