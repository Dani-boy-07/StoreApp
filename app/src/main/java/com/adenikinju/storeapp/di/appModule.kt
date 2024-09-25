package com.adenikinju.storeapp.di

import com.adenikinju.storeapp.data.datasource.remote.apiInterface
import com.adenikinju.storeapp.data.repository.Repository
import com.adenikinju.storeapp.domain.repository.RepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appModule {

    @Singleton
    @Provides
    fun providesRetrofit(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun providesRepository(
        api: apiInterface
    ): Repository {
        return RepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesApiInterface(
        retrofit: Retrofit
    ): apiInterface {
        return retrofit.create(apiInterface::class.java)
    }

}