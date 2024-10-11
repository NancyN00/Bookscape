package com.example.simplebooks.data.remote

import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.models.BookListItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookListApi {

    @GET("/books")
    suspend fun getBookList(
        @Query("type") type: String? = null,
    ): List<BookListItem>

    @GET("/books/{bookId}")
    suspend fun getBookDetails(
        @Path("bookId") bookId: Int
    ): BookDetailsItem

}