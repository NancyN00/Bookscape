package com.example.simplebooks.presentation.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShieldMoon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simplebooks.R
import com.example.simplebooks.navigation.Screens

@Composable
fun SettingsScreen(navController: NavController) {


    var isChecked by remember { mutableStateOf(false) }
    val painter =
        if (isChecked) {
            painterResource(id = R.drawable.toggle_on)
        } else {
            painterResource(id = R.drawable.toggle_off)
        }

    Column(
        modifier = Modifier.fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {

        Text(
            text = "Settings",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Account",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.bookspaceicon),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape)
                    .size(40.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Kerry Ancy",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Text(
                    text = "Personal Info",
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                IconButton(onClick = {
                    navController.navigate(Screens.AccountScreen.name)
                }) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Arrow Forward",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "Settings",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {}) {
                Icon(Icons.Default.Language, contentDescription = "Language")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Language",
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Arrow Forward",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {}) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Notification",
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Arrow Forward",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {}) {
                Icon(Icons.Default.Info, contentDescription = "Request")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Request",
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Arrow Forward",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {}) {
                Icon(Icons.Default.ShieldMoon, contentDescription = "Mode")
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Dark Mode",
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier =
                Modifier.size(40.dp)
                    .background(Color.LightGray, RoundedCornerShape(10.dp))
                    .padding(8.dp)
                    .clickable { isChecked = !isChecked }
            ) {
                Image(painter = painter,
                    contentDescription = "Dark/Light Mode",
                    modifier = Modifier.size(50.dp),
                    colorFilter = if (isChecked) {
                        ColorFilter.tint(Color.Black)
                    } else {
                        ColorFilter.tint(Color.Gray)
                    }

                    )
            }
        }

    }

}

