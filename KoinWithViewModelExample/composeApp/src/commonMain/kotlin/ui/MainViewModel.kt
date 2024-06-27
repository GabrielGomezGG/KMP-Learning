package ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    wea: String
) : ViewModel() {

    private val _timer = MutableStateFlow(0)
    val timer = _timer.asStateFlow()

    init {
        startTimer()
        println(wea)
    }

    private fun startTimer(){
        viewModelScope.launch(Dispatchers.IO) {
            while(true){
                delay(1000)
                _timer.value++
            }
        }
    }
}