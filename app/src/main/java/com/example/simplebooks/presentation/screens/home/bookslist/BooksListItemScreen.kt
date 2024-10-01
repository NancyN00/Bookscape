package com.example.simplebooks.presentation.screens.home.bookslist

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.simplebooks.navigation.Screens
import com.example.simplebooks.presentation.screens.home.ItemLayout.BooksListItemLayout

private const val TAG = "AppLogger"

@Composable
fun BooksListItemScreen(
    booksListViewModel: BooksListViewModel = hiltViewModel(),
    navController: NavController
) {

    Log.d(TAG, "my Message")
    val bookList by booksListViewModel.booksListState.collectAsStateWithLifecycle()

    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            if (bookList.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    //color = MaterialTheme.colorScheme.onError
                )
            }
        }
        item {
            if (bookList.message.isNotEmpty()) {
                Text(
                    text = bookList.message,
                    color = MaterialTheme.colorScheme.onBackground
                )

            }
        }
        items(bookList.booksList) { books ->
            Card(
                onClick = {
                          navController.navigate("${Screens.BookDetailsScreen.name}/${books.id}")
                },
                modifier = Modifier
                    .size(width = 160.dp, height = 80.dp)
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
                )

            {
                BooksListItemLayout(
                    booksItem = books,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                )
            }
            }
        }

    }