package com.example.simplebooks.presentation.screens.home.ItemLayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplebooks.domain.models.BookListItem

@Composable
fun FictionItemLayout(
    modifier: Modifier = Modifier,
    booksItem: BookListItem
) {
    Card(
        modifier = modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Text(
                text = booksItem.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Type: ${booksItem.type}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Thin
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = if (booksItem.available) "Available" else "Not Available",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = if (booksItem.available) Color.Green else Color.Red
            )
        }
    }
}

