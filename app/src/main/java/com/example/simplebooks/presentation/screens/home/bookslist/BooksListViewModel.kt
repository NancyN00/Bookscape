package com.example.simplebooks.presentation.screens.home.bookslist

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
class BooksListViewModel @Inject constructor(
    private val bookListRepository: BookListRepository
) : ViewModel() {

    private val _booksListState = MutableStateFlow(BooksListState())
    val booksListState = _booksListState.asStateFlow()

    private val _fictionBooksState = MutableStateFlow(BooksListState())
    val fictionBooksState = _fictionBooksState.asStateFlow()

    private val _nonFictionBooksState = MutableStateFlow(BooksListState())
    val nonFictionBooksState = _nonFictionBooksState.asStateFlow()

    init {
        getBooksList()
        getFictionBooks()
        getNonFictionBooks()
    }

    private fun getNonFictionBooks() {
        bookListRepository.getNonFictionBooks().onEach { books ->
            when (books) {
                is Resource.Loading -> {
                    _nonFictionBooksState.value = BooksListState(isLoading = true)
                }

                is Resource.Error -> {
                    _nonFictionBooksState.value = BooksListState(
                        message = books.message ?: "Something went wrong"
                    )
                }

                is Resource.Success -> {
                    _nonFictionBooksState.value = BooksListState(
                        booksList = books.data ?: emptyList()
                    )
                }
            }
            /**remember to launch the flow **/
        }.launchIn(viewModelScope)
    }

    private fun getFictionBooks() {
        bookListRepository.getFictionBooks().onEach { books ->
            when (books) {
                is Resource.Loading -> {
                    _fictionBooksState.value = BooksListState(isLoading = true)
                }

                is Resource.Error -> {
                    _fictionBooksState.value = BooksListState(
                        message = books.message ?: "Something went wrong"
                    )
                }

                is Resource.Success -> {
                    _fictionBooksState.value = BooksListState(
                        booksList = books.data ?: emptyList()
                    )
                }
            }
            /**remember to launch the flow **/
        }.launchIn(viewModelScope)
    }


    private fun getBooksList() {
        bookListRepository.getBooksList().onEach { books ->
            when (books) {
                is Resource.Loading -> {
                    _booksListState.value = BooksListState(
                        isLoading = true
                    )
                }

                is Resource.Error -> {
                    _booksListState.value = BooksListState(
                        message = books.message ?: "Something went wrong"

                    )

                }

                is Resource.Success -> {
                    _booksListState.value = BooksListState(
                        booksList = books.data ?: emptyList()
                    )

                }
            }
        }.launchIn(viewModelScope)

    }

}