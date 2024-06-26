package data

import app.cash.sqldelight.db.SqlDriver
import com.gg.User
import com.gg.titidatabase

class UserDao(
    private val sqlDriver: SqlDriver
) {

    private val database = titidatabase(sqlDriver)
    private val userQueries = database.titidatabaseQueries

    fun getAllUsers(): List<User> {
        return userQueries.selectAllUser().executeAsList()
    }

    fun insertNewUser(){
        userQueries.insertNewUser()
    }

    fun insertNewUserFromObject(user: User){
        userQueries.insertNewUserFromObject(user)
    }

    fun deleteUser(userId: Long){
        userQueries.deleteUser(userId)
    }

}