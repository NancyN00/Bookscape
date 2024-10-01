package com.example.simplebooks.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.simplebooks.presentation.screens.bookdetails.BookDetailsScreen
import com.example.simplebooks.presentation.screens.favorite.FavoriteScreen
import com.example.simplebooks.presentation.screens.home.HomeScreen
import com.example.simplebooks.presentation.screens.settings.SettingsScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimpleBooksNavigation() {

    val navController : NavHostController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfItems.forEach { bottomNav ->

                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == bottomNav.route } == true,
                        onClick = {
                            navController.navigate(bottomNav.route){
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = bottomNav.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = bottomNav.label)
                        }
                    )

                }

            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name
        ){
            composable(route = Screens.HomeScreen.name){
                HomeScreen(navController = navController)

            }

            // Route for the Book Details screen with a dynamic bookId
            composable(route = "${Screens.BookDetailsScreen.name}/{bookId}") { backStackEntry ->
                val bookId = backStackEntry.arguments?.getString("bookId")?.toInt() ?: 0
                BookDetailsScreen(bookId = bookId, navController = navController)

            }

            composable(route = Screens.FavoriteScreen.name){
                FavoriteScreen()

            }
            composable(route = Screens.SettingsScreen.name){
                SettingsScreen()

            }
        }


    }




}