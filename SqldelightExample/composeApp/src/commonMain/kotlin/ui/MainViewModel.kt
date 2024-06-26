package ui

import androidx.lifecycle.ViewModel
import com.gg.User
import data.UserDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
//    private val userDao: UserDao
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    init {
//        _user.value = userDao.getAllUsers().firstOrNull()
        _user.value = User(1, "John Doe")
    }

}