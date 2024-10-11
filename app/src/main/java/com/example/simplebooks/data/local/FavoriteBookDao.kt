package com.example.simplebooks.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplebooks.domain.models.FavoriteBookEntity

/**DAO interface manages favorite books. **/
@Dao
interface FavoriteBookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToFavorites(book: FavoriteBookEntity)

    @Delete
    suspend fun removeFromFavorites(book: FavoriteBookEntity)

    @Query("SELECT * FROM favorite_books")
    suspend fun getFavoriteBooks(): List<FavoriteBookEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_books WHERE id = :bookId)")
    suspend fun isBookInFavorites(bookId: Int): Boolean

}



