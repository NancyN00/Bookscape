package com.example.simplebooks.presentation.screens.bookdetails

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplebooks.domain.models.BookDetailsItem
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.domain.repository.FavoriteBookRepository
import com.example.simplebooks.presentation.components.showToast
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
    private val favBookRepository: FavoriteBookRepository
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

    // check if the book is in favorites
    fun checkIfFavorite(bookId: Int) {
        viewModelScope.launch {
            //  _isFavorite.value = favBookRepository.isBookInFavorites(bookId)

            val favoriteStatus = favBookRepository.isBookInFavorites(bookId)
            Log.d(
                "BookDetailViewModel",
                "checkIfFavorite() called for bookId: $bookId, favoriteStatus: $favoriteStatus"
            )
            _isFavorite.value = favoriteStatus

        }
    }

    fun toggleFavorite(book: BookDetailsItem, context: Context) {
        viewModelScope.launch {
            val isFavorite = favBookRepository.isBookInFavorites(book.id)

            Log.d(
                "BookDetailViewModel",
                "toggleFavorite() called for book: ${book.name}, isFavorite: $isFavorite"
            )

            if (isFavorite) {

                showToast(context, "${book.name} removed from favorites")
                Log.d("BookDetailViewModel", "Removing book from favorites: ${book.name}")
                favBookRepository.removeFromFavorites(book.toFavoriteBookEntity())
            } else {
                Log.d("BookDetailViewModel", "Adding book to favorites: ${book.name}")

                showToast(context, "${book.name} added to favorites")
                favBookRepository.addToFavorites(book.toFavoriteBookEntity())
            }
            /** Update the UI state to reflect the new favorite status **/

            Log.d("BookDetailViewModel", "New isFavorite state: ${_isFavorite.value}")
            _isFavorite.value = !isFavorite

        }
    }
}