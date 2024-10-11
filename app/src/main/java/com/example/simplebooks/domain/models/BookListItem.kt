package com.example.simplebooks.domain.models

data class BookListItem(
    val available: Boolean,
    val id: Int,
    val name: String,
    val type: String
)