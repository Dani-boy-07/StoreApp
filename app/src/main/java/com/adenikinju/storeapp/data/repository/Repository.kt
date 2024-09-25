package com.adenikinju.storeapp.data.repository

import com.adenikinju.storeapp.data.models.storeitemsmodel
import com.adenikinju.storeapp.data.models.storeitemsmodelItem

interface Repository {
    suspend fun getAllItems(): List<storeitemsmodelItem>
    suspend fun getSingleItem(id: Int): storeitemsmodelItem
}