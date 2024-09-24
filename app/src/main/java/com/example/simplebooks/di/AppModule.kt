package com.example.simplebooks.di

import com.example.simplebooks.data.remote.BookListApi
import com.example.simplebooks.data.repository.BookListRepositoryImpl
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitApi(): BookListApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookListApi::class.java)
    }

    @Singleton
    @Provides
    fun provideBooksListRepository(api: BookListApi): BookListRepository {
        return BookListRepositoryImpl(api)
    }
}

