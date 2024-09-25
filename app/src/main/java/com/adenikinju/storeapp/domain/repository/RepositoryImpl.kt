package com.adenikinju.storeapp.domain.repository

import com.adenikinju.storeapp.data.datasource.remote.apiInterface
import com.adenikinju.storeapp.data.models.storeitemsmodel
import com.adenikinju.storeapp.data.models.storeitemsmodelItem
import com.adenikinju.storeapp.data.repository.Repository
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val api: apiInterface
) : Repository {
    override suspend fun getAllItems(): List<storeitemsmodelItem> = api.getAllItems()
    override suspend fun getSingleItem(id: Int): storeitemsmodelItem  = api.getSingleItem(id)
}