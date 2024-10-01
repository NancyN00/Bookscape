package com.example.simplebooks.presentation.screens.bookdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplebooks.domain.repository.BookListRepository
import com.example.simplebooks.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val bookDetRepImpl: BookListRepository
) : ViewModel() {

    private val _bookDetState = MutableStateFlow(BookDetailsState())
    val bookDetState = _bookDetState.asStateFlow()
    fun getBookDetails(bookId: Int) {
        bookDetRepImpl.getBookDetail(bookId).onEach { bookDetails ->

            Log.d("BookDetailViewModel", "Fetching details for bookId: $bookId")
            when(bookDetails){
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
}