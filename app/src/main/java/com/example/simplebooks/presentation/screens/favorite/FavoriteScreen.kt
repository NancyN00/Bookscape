package com.example.simplebooks.presentation.screens.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.simplebooks.navigation.Screens

@Composable
fun FavoriteScreen(
    favoriteBookViewModel: FavoriteBooksViewModel = hiltViewModel(),
    navController: NavHostController
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {

        Text(
            text = "Favorite Books",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )

        LaunchedEffect(Unit) {
            favoriteBookViewModel.getFavoriteBooks()
        }

        // Collect the list of favorite books
        val favoriteBooks by favoriteBookViewModel.favoriteBooks.collectAsStateWithLifecycle()

        if (favoriteBooks.isEmpty()) {
            // Show a message if there are no favorite books
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No favorite books found", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            // Display the list of favorite books
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(favoriteBooks) { book ->

                    FavoriteBookItemLayout(
                        book = book,
                        onClick = {
                            // Navigate to book details screen
                            navController.navigate("${Screens.BookDetailsScreen.name}/${book.id}")
                        }

                    )

                }


            }

        }
    }
}