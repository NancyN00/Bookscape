package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.simplebooks.presentation.screens.home.ItemLayout.FictionItemLayout

@Composable
fun FictionBookListItemScreen(
    fictionBooksListViewModel: BooksListViewModel = hiltViewModel()
){

    val fictionBooksState by fictionBooksListViewModel.fictionBooksState.collectAsStateWithLifecycle()

    Text(text = "Fiction",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        color = Color.Green
        )

    if (fictionBooksState.isLoading) {
        CircularProgressIndicator(modifier = Modifier)
    } else if (fictionBooksState.message.isNotEmpty()) {
        Text(
            text = fictionBooksState.message,
            color = MaterialTheme.colorScheme.error,
           // modifier = Modifier.align(Alignment.Center)
        )
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(fictionBooksState.booksList) { book ->
                FictionItemLayout(booksItem = book)
            }
        }
    }
}