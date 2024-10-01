package com.example.simplebooks.presentation.screens.bookdetails

import com.example.simplebooks.domain.models.BookDetailsItem

data class BookDetailsState(
    val isLoading: Boolean = false,
    val message: String = "",
    val booksList: BookDetailsItem? = null
)
