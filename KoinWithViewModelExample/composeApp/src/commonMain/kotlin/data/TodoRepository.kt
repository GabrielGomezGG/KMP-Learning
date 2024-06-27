package data

import data.local.TodoDao
import data.local.TodoEntity

class TodoRepository(
    private val todoDao: TodoDao
) {
    fun getTodos() = todoDao.getAllAsFlow()

    suspend fun deleteTodo(todoEntity: TodoEntity) = todoDao.delete(todoEntity)

    suspend fun insertTodo(todoEntity: TodoEntity) = todoDao.insert(todoEntity)
}