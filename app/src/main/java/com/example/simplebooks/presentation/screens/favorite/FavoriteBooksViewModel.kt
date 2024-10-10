package com.example.simplebooks.presentation.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplebooks.domain.models.FavoriteBookEntity
import com.example.simplebooks.domain.repository.FavoriteBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteBooksViewModel @Inject constructor(
    private val repository: FavoriteBookRepository
) : ViewModel() {

    private val _favoriteBooks = MutableStateFlow<List<FavoriteBookEntity>>(emptyList())
    val favoriteBooks: StateFlow<List<FavoriteBookEntity>> = _favoriteBooks

    fun getFavoriteBooks() {
        viewModelScope.launch {
            _favoriteBooks.value = repository.getFavoriteBooks()
        }
    }

    fun loadFavouriteBooks() {
        viewModelScope.launch {
            _favoriteBooks.value = repository.getFavoriteBooks()
        }
    }

    fun addToFavorite(book: FavoriteBookEntity) {
        viewModelScope.launch {
            repository.addToFavorites(book)
            loadFavouriteBooks()
        }
    }

    fun removeFromFavorites(book: FavoriteBookEntity) {
        viewModelScope.launch {
            repository.removeFromFavorites(book)
            loadFavouriteBooks()
        }
    }

    fun isBookInFavorites(
        bookId: Int,
        callback: (Boolean) -> Unit
    ) {
        viewModelScope.launch {
            callback(repository.isBookInFavorites(bookId))
        }
    }

    fun toggleFavorite(book: FavoriteBookEntity) {
        viewModelScope.launch {
            val isFavorite = repository.isBookInFavorites(book.id)
            if (isFavorite) {
                removeFromFavorites(book)
            } else {
                addToFavorite(book)
            }
        }
    }

}