package com.example.simplebooks.presentation.screens.home.bookslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplebooks.domain.models.BookListItem

@Composable
fun BooksListItemLayout(
    modifier: Modifier = Modifier,
    booksItem: BookListItem
) {
    Column(modifier = Modifier.padding(start = 4.dp, top = 4.dp)) {
        /**Book name **/
        Text(
            text = booksItem.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
           verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            /**Type (Fiction or non-fiction **/

            Text(
                text = booksItem.type,
                fontSize = 15.sp,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )

            /**Available **/


            Text(
                text = if(booksItem.available) "Available" else "Not Available",
                fontSize = 15.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                color = if (booksItem.available) Color.Green else Color.Red,
                modifier = Modifier.weight(1f)
            )

        }
    }
}