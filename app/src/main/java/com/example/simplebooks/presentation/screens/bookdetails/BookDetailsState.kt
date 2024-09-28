package com.example.simplebooks.presentation.screens.bookdetails

import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.models.BookListItem

data class BookDetailsState(
    val isLoading: Boolean = false,
    val message: String = "",
    val booksList: List<BookDetailsItem> = emptyList()
)
