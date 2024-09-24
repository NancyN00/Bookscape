package com.example.simplebooks.domain.repository

import com.example.simplebooks.domain.models.BookListItem
import com.example.simplebooks.util.Resource
import kotlinx.coroutines.flow.Flow

interface BookListRepository {

    fun getCharacterList(): Flow<Resource<List<BookListItem>>>

}