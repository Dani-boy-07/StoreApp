package com.adenikinju.storeapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adenikinju.storeapp.data.models.storeitemsmodelItem
import com.adenikinju.storeapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _storeItems = MutableStateFlow<List<storeitemsmodelItem>>(emptyList())
    val storeItems: StateFlow<List<storeitemsmodelItem>> = _storeItems


    init {
        getAllItems()
    }

    private fun getAllItems() {
        viewModelScope.launch {
            try {
                val result = repository.getAllItems()
                Log.e("HomeViewModel", "getAllItems: $result")
                _storeItems.emit(result)
            } catch (e: Exception) {
                // Handle error
                print(e.message)
            }
        }
    }

    fun getSingleItem(id: Int): storeitemsmodelItem? {
        val result = _storeItems.value.find {
            it.id == id
        }
        return result
    }

}