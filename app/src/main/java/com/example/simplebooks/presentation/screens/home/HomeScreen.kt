package com.example.simplebooks.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplebooks.presentation.components.ProfileHeader
import com.example.simplebooks.presentation.screens.home.bookslist.BookListScreen
import com.example.simplebooks.presentation.screens.home.search.SearchScreen

@Composable
fun HomeScreen(){

    Column(modifier = Modifier.fillMaxSize()
        .windowInsetsPadding(WindowInsets.systemBars)
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)) {

        Text(text = "Simple Books",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        ProfileHeader()

        Spacer(modifier = Modifier.height(10.dp))

        SearchScreen()

        Spacer(modifier = Modifier.height(20.dp))

        BookListScreen()
    }








}