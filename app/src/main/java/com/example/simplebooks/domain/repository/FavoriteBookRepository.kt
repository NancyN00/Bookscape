package com.example.simplebooks.domain.repository

import com.example.simplebooks.data.local.FavoriteBookDao
import com.example.simplebooks.domain.models.FavoriteBookEntity
import javax.inject.Inject

class FavoriteBookRepository @Inject constructor (private val dao: FavoriteBookDao){

    suspend fun addToFavorites(book : FavoriteBookEntity){
        dao.addToFavorites(book)
    }

    suspend fun removeFromFavorites(book: FavoriteBookEntity){
        dao.removeFromFavorites(book)
    }

    suspend fun getFavoriteBooks() : List<FavoriteBookEntity>{
       return dao.getFavoriteBooks()
    }

    suspend fun isBookInFavorites(bookId: Int): Boolean {
        return dao.isBookInFavorites(bookId)
    }

}