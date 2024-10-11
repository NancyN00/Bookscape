package com.example.simplebooks.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailsItem(
    @SerialName("author")
    val author: String,
    @SerialName("available")
    val available: Boolean,
    @SerialName("current-stock")
    val currentStock: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("isbn")
    val isbn: String?,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Double,
    @SerialName("type")
    val type: String,
    val isFavorite: Boolean = false
) {
    /** convert BookDetailsItem to FavoriteBookEntity **/
    fun toFavoriteBookEntity(): FavoriteBookEntity {
        return FavoriteBookEntity(
            id = this.id,
            name = this.name,
            author = this.author,
            type = this.type,
            isbn = this.isbn ?: "N/A",
            price = this.price,
            currentStock = this.currentStock,
            available = this.available
        )
    }

}