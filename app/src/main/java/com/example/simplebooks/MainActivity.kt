package com.example.simplebooks

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.simplebooks.navigation.SimpleBooksNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

 //   private val viewModel: BooksListViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        installSplashScreen().apply {
//            setKeepOnScreenCondition {
//                viewModel.booksListState.value.isLoading
//            }
//        }

        setContent {
            SimpleBooksNavigation()
        }
    }
}
