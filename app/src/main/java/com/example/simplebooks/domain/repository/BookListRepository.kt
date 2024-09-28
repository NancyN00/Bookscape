package com.example.simplebooks.domain.repository

import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.models.BookListItem
import com.example.simplebooks.util.Resource
import kotlinx.coroutines.flow.Flow

interface BookListRepository {

    fun getBooksList(): Flow<Resource<List<BookListItem>>>

    fun getFictionBooks() : Flow<Resource<List<BookListItem>>>

    fun getNonFictionBooks() : Flow<Resource<List<BookListItem>>>

    fun getBookDetail(bookId: Int) : Flow<Resource<List<BookDetailsItem>>>

}