package com.example.simplebooks.presentation.screens.bookdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun BookDetailsScreen(
    bookId: Int?,
    bookDetailViewModel: BookDetailViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val context = LocalContext.current

    //  Log.d("BookDetailsScreen", "bookDetListState: $bookDetListState")

    /** Trigger fetching the book details based on the bookId **/
    LaunchedEffect(bookId) {
        if (bookId != null) {
            bookDetailViewModel.getBookDetails(bookId)
            //is the book in favorite?
            bookDetailViewModel.checkIfFavorite(bookId)
        }
    }

    /** Collect the isFavorite state from the ViewModel**/
    val isFavorite by bookDetailViewModel.isFavorite.collectAsStateWithLifecycle()

    val bookDetListState by bookDetailViewModel.bookDetState.collectAsStateWithLifecycle()


    if (bookDetListState.isLoading) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator(
                modifier = Modifier,
            )
        }
    } else {
        Column {

            if (bookDetListState.message.isNotEmpty()) {
                Text(
                    text = bookDetListState.message,
                    color = MaterialTheme.colorScheme.onBackground,
                )

            }
            /** check if bookDetListState.bookDetails is null **/
            bookDetListState.booksList?.let { bookDetail ->
                BookDetailItemLayout(
                    bookDetItem = bookDetail,
                    navController = navController,
                    onFavoriteClick = {
                        /**the add/remove from favorites onclick functionality **/

                        bookDetailViewModel.toggleFavorite(bookDetail, context)
                    },

                    /**pass the isFavorite state to update the UI **/
                    isFavorite = isFavorite
                )

            }
        }
    }
}