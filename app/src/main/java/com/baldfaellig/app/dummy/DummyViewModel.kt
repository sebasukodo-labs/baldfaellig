package com.baldfaellig.app.dummy

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DummyViewModel: ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun increment() {
        viewModelScope.launch {
            _counter.value += 1
        }
    }
}

class DummySecondViewModel(private val db: DummyDatabase): ViewModel() {
    private val _name = MutableStateFlow<String?>(null)
    val name:StateFlow<String?> = _name

    fun loadName() {
        viewModelScope.launch {
            val items = db.dummyDao().getAll()
            _name.value = items.firstOrNull()?.name
        }
    }
}

class DummySecondViewModelFactory(private val db: DummyDatabase): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return DummySecondViewModel(db) as T
    }
}