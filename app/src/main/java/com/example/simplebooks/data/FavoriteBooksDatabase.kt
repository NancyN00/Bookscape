package com.example.simplebooks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplebooks.data.local.FavoriteBookDao
import com.example.simplebooks.domain.models.FavoriteBookEntity

/**Set up the Room database that holds the FavoriteBookDao.**/
@Database(entities = [FavoriteBookEntity::class], version = 1)
abstract class FavoriteBooksDatabase : RoomDatabase() {
    abstract fun favoriteBookDao(): FavoriteBookDao
}