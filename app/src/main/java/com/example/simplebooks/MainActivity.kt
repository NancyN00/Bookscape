package com.example.simplebooks

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.simplebooks.navigation.SimpleBooksNavigation
import com.example.simplebooks.ui.theme.SimpleBooksTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleBooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SimpleBooksNavigation()


                }

            }
        }
    }
}
