package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.simplebooks.presentation.screens.home.ItemLayout.NonFictionItemLayout

@Composable
fun NonFictionBookListItemScreen(
    nonFictionBooksListViewModel: BooksListViewModel = hiltViewModel()
) {
    Column {
        Text(
            text = "Non-Fiction",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.Red
        )

        val nonfictionState by nonFictionBooksListViewModel.nonFictionBooksState.collectAsStateWithLifecycle()

        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                if (nonfictionState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier,
                        //   color = MaterialTheme.colorScheme.onError
                    )
                }
            }

            item {
                if (nonfictionState.message.isNotEmpty()) {
                    Text(
                        text = nonfictionState.message,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                }
            }

            items(nonfictionState.booksList) { nonficbooks ->
                Card(
                    modifier = Modifier
                        .size(width = 180.dp, height = 100.dp)
                        .padding(start = 10.dp, top = 5.dp, end = 10.dp),
                    elevation = CardDefaults.cardElevation(5.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                )

                {
                    NonFictionItemLayout(
                        booksItem = nonficbooks,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),

                        )
                }

            }

        }
    }
}