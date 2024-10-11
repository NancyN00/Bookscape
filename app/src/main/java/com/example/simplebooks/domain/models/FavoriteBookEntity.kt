package com.example.simplebooks.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**Define the Room Entity for storing favorite books in the local database.**/
@Entity(tableName = "favorite_books")
data class FavoriteBookEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val author: String,
    val type: String,
    val isbn: String,
    val price: Double,
    val currentStock: Int,
    val available: Boolean
)

