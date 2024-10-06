package com.example.simplebooks.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountTextInput(
    text : String,
    onTextChange: (String) -> Unit

){

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,  // Remove the background box
            focusedIndicatorColor = Color.Black,  // Color of the underline when focused
            unfocusedIndicatorColor = Color.Gray, // Color of the underline when unfocused
            disabledIndicatorColor = Color.Transparent, // If disabled, no underline
            focusedTextColor = Color.Black,

    )
    )
}