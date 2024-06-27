import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import data.local.TodoDao
import data.local.TodoEntity
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import ui.MainViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun App(
    todoDao: TodoDao
) {

    LaunchedEffect(true) {
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

        todoList.forEach {
            todoDao.insert(it)
        }
    }

    MaterialTheme {
        KoinContext {

            val mainViewModel = koinInject<MainViewModel>()
            val timer by mainViewModel.timer.collectAsState(0)

            val todos by todoDao.getAllAsFlow().collectAsState(emptyList())
            val scope = rememberCoroutineScope()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        text = "Timer: $timer",
                        style = MaterialTheme.typography.h4
                    )
                }
                items(todos) {
                    ListItem(
                        text = { Text(it.title) },
                        secondaryText = { Text(it.content) },
                        modifier = Modifier.clickable {
                            scope.launch {
                                todoDao.delete(it)
                            }
                        }
                    )
                }
            }
        }
    }
}