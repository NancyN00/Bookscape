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

      init {
          getBooksList()
      }

    private fun getBooksList() {
        bookListRepository.getCharacterList().onEach { books ->
            when(books){
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