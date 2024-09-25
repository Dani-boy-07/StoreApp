package com.adenikinju.storeapp.data.datasource.remote

import com.adenikinju.storeapp.data.models.storeitemsmodel
import com.adenikinju.storeapp.data.models.storeitemsmodelItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface apiInterface {
    @GET("products")
    suspend fun getAllItems(): List<storeitemsmodelItem>

    @GET("products/{id}")
    suspend fun getSingleItem(@Path("id")id: Int): storeitemsmodelItem

}