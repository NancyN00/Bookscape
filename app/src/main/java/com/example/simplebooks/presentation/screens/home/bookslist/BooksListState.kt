package com.example.simplebooks.presentation.screens.home.bookslist

import com.example.simplebooks.domain.models.BookListItem
data class BooksListState(
    val isLoading: Boolean = false,
    val message: String = "",
    val booksList: List<BookListItem> = emptyList()
    )
