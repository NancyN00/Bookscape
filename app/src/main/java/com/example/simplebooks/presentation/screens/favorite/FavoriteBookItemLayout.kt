package com.example.simplebooks.presentation.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.simplebooks.domain.models.FavoriteBookEntity

@Composable
fun FavoriteBookItemLayout(book: FavoriteBookEntity, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .shadow(4.dp)
            .clickable { onClick() }

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = book.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = book.author,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = book.type,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }

}