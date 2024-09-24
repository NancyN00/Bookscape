package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplebooks.domain.models.BookListItem

@Composable
fun BooksListItemLayout(
    modifier: Modifier = Modifier,
    booksItem: BookListItem
) {
    Column(modifier = Modifier.padding(4.dp)) {
        /**Book name **/
        Text(
            text = booksItem.name,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.weight(1f))

            /**Type (Fiction or non-fiction **/

            Text(
                text = booksItem.type,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold
            )

            /**Available **/


            Text(
                text = if(booksItem.available) "Available" else "Not Available",
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Red
            )

        }
    }
}