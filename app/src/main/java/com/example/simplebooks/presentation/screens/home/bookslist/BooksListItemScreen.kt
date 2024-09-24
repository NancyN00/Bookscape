package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun BooksListItemScreen(
    booksListViewModel: BooksListViewModel = hiltViewModel(),
) {

    val bookList by booksListViewModel.booksListState.collectAsStateWithLifecycle()

//    Card(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 160.dp, height = 80.dp).padding(start = 10.dp, top = 5.dp, end = 10.dp),
//      //  colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
//        elevation = CardDefaults.cardElevation(5.dp)
//    )
    Box(
       // modifier = Modifier.fillMaxSize(),
        //contentAlignment = Alignment.Center
    ) {

        if (bookList.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier,
                color = MaterialTheme.colorScheme.onError
            )
        }

        if (bookList.message.isNotEmpty()) {
            Text(
                text = bookList.message,
                color = MaterialTheme.colorScheme.onBackground
            )

        }

        //        LazyRow(
//            modifier = Modifier,
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(bookList.booksList) { books ->

                BooksListItemLayout(
                    booksItem = books,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                    )
            }
        }

    }
}