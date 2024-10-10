package com.example.simplebooks.presentation.screens.bookdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.domain.repository.FavoriteBookRepository
import com.example.simplebooks.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val bookDetRepImpl: BookListRepository,
    private val favBookRepository : FavoriteBookRepository
) : ViewModel() {

    private val _bookDetState = MutableStateFlow(BookDetailsState())
    val bookDetState = _bookDetState.asStateFlow()

    // State for the current book's favorite status
    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    fun getBookDetails(bookId: Int) {
        bookDetRepImpl.getBookDetail(bookId).onEach { bookDetails ->

            Log.d("BookDetailViewModel", "Fetching details for bookId: $bookId")
            when (bookDetails) {
                is Resource.Loading -> {
                    _bookDetState.value = BookDetailsState(
                        isLoading = true
                    )
                }

                is Resource.Error -> {
                    _bookDetState.value = BookDetailsState(
                        message = bookDetails.message ?: "Something went wrong"
                    )
                }

                is Resource.Success -> {
                    _bookDetState.value = BookDetailsState(
                        booksList = bookDetails.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    // Fetch if the book is in favorites
    fun checkIfFavorite(bookId: Int) {
        viewModelScope.launch {
            _isFavorite.value = favBookRepository.isBookInFavorites(bookId)
        }
    }

    fun toggleFavorite(book: BookDetailsItem) {
        viewModelScope.launch {
            val isFavorite = favBookRepository.isBookInFavorites(book.id)
            if (isFavorite) {
                favBookRepository.removeFromFavorites(book.toFavoriteBookEntity())
            } else {
                favBookRepository.addToFavorites(book.toFavoriteBookEntity())
            }
            // Update the UI state to reflect the new favorite status
            _isFavorite.value = !isFavorite

        }
    }
}