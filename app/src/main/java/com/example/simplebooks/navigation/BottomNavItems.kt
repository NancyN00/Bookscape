package com.example.simplebooks.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItems(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfItems: List<BottomNavItems> = listOf(
    BottomNavItems(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),

    BottomNavItems(
        label = "Favorite",
        icon = Icons.Default.Favorite,
        route = Screens.FavoriteScreen.name
    ),

    BottomNavItems(
        label = "Settings",
        icon = Icons.Default.Settings,
        route = Screens.SettingsScreen.name
    )
)




