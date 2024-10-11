package com.example.simplebooks.domain.repository

import android.util.Log
import com.example.simplebooks.data.local.FavoriteBookDao
import com.example.simplebooks.domain.models.FavoriteBookEntity
import javax.inject.Inject

class FavoriteBookRepository @Inject constructor(private val dao: FavoriteBookDao) {

    suspend fun addToFavorites(book: FavoriteBookEntity) {
        Log.d("FavoriteBookRepository", "addToFavorites() called for bookId: ${book.id}")

        /**check if book already in fav before adding**/

        if (!isBookInFavorites(book.id)) {
            dao.addToFavorites(book)
        }
    }

    suspend fun removeFromFavorites(book: FavoriteBookEntity) {
        Log.d("FavoriteBookRepository", "removeFromFavorites() called for bookId: ${book.id}")

        dao.removeFromFavorites(book)
    }

    suspend fun getFavoriteBooks(): List<FavoriteBookEntity> {
//        Log.d("FavoriteBookRepository", "getFavoriteBooks() called, total favorites: ${favoriteBooks.size}")
//       return dao.getFavoriteBooks()

        val favoriteBooks = dao.getFavoriteBooks()
        Log.d(
            "FavoriteBookRepository",
            "getFavoriteBooks() called, total favorites: ${favoriteBooks.size}"
        )
        return favoriteBooks
    }

    suspend fun isBookInFavorites(bookId: Int): Boolean {
        //  return dao.isBookInFavorites(bookId)

        val isInFavorites = dao.isBookInFavorites(bookId)
        Log.d(
            "FavoriteBookRepository",
            "isBookInFavorites() called for bookId: $bookId, isInFavorites: $isInFavorites"
        )
        return isInFavorites
    }

}