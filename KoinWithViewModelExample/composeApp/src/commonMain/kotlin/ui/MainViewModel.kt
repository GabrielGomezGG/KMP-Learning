package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.TodoRepository
import data.local.TodoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val todos = MutableStateFlow<List<TodoEntity>>(emptyList())
    val todosFlow = todos.asStateFlow()

    init {

        val todoList = listOf(
            TodoEntity(
                title = "Test",
                content = "Test description"
            ),
            TodoEntity(
                title = "Test 2",
                content = "Test description 2"
            ),
            TodoEntity(
                title = "Test 3",
                content = "Test description 3"
            ),
            TodoEntity(
                title = "Test 4",
                content = "Test description 4"
            ),
            TodoEntity(
                title = "Test 5",
                content = "Test description 5"
            )
        )

        todoList.forEach{
            insertTodo(it)
        }

        getTodos()
    }

    private fun getTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.getTodos().collect{
                todos.value = it
            }
        }
    }

    fun insertTodo(todo: TodoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.insertTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteTodo(todo)
        }
    }
}