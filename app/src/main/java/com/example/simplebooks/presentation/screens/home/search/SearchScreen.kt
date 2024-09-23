package com.example.simplebooks.presentation.screens.home.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.simplebooks.R

@Composable
fun SearchScreen() {

    var books by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        OutlinedTextField(
            value = books,
            onValueChange = { books = it },
            placeholder = { Text(text = "Search for books") },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Green,
            ),
            shape = RoundedCornerShape(10.dp)
        )

       // Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .background(
                    color = Color.DarkGray,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center,
        ){
            Icon(painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                tint = Color.Red,
                modifier = Modifier.size(40.dp)
                )
        }
    }
}