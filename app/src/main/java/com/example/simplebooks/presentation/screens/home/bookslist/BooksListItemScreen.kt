package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookListScreen(){

    LazyRow(modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        )
    {
        items(6){
            BooksListItemScreen()
        }
    }
}
@Composable
fun BooksListItemScreen() {

    Card(
        onClick = {},
        modifier = Modifier
            .size(width = 140.dp, height = 80.dp).padding(start = 10.dp, top = 5.dp, end = 10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
      elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)){
            /**Book name **/
            Text(text = "The Sycamore Tree",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
                )

            Row (
               // modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                /**Available **/

                Text(text = "Available",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    )

                Spacer(modifier = Modifier.weight(1f))

                /**Type (Fiction or non-fiction **/

                Text(text = "Fiction",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold)

            }
        }

    }
}