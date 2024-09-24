package com.example.simplebooks.data.remote

import com.example.simplebooks.domain.models.BookListItem
import retrofit2.http.GET

interface BookListApi {

    @GET ("/books")
    suspend fun getBookList() : List<BookListItem>

}