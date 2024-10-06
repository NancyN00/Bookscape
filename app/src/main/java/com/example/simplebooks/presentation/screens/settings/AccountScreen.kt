package com.example.simplebooks.presentation.screens.settings

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simplebooks.presentation.components.AccountTextInput

@Composable
fun AccountScreen(
    navController: NavController
) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var isFemaleSelected by remember { mutableStateOf(false) }
    var isMaleSelected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Keyboard Arrow Left",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Blue, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                IconButton(onClick = {
                    Toast.makeText(
                        context,
                        "Personal Info Saved",
                        Toast.LENGTH_SHORT
                    ).show()

                }) {
                    Icon(
                        Icons.Default.Done,
                        contentDescription = "Done",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Account",
            fontSize = 25.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Photo",
                modifier = Modifier,
                color = Color.LightGray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.LightGray, RoundedCornerShape(50.dp))
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)

            ) {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Person",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Upload Image",
            color = Color.Blue,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .clickable {
                    Toast.makeText(context,
                        "Uploaded",
                        Toast.LENGTH_SHORT).show()
                }
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Name",
                modifier = Modifier,
                color = Color.LightGray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            AccountTextInput(
                text = name,
                onTextChange = { name = it })

        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Gender",
                modifier = Modifier.padding(end = 16.dp),
                color = Color.LightGray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            // Male Chip
            AssistChip(
                onClick = {
                    isMaleSelected = true
                    isFemaleSelected = false  // Unselect female when male is selected
                },
                label = { Text(text = "Male") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Male, // Use your male icon here
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (isMaleSelected) Color.Blue else Color.Gray,  // Purple when selected
                    labelColor = Color.White
                )
            )

            Spacer(modifier = Modifier.width(16.dp))  // Adds space between the chips

            // Female Chip
            AssistChip(
                onClick = {
                    isFemaleSelected = true
                    isMaleSelected = false  // Unselect male when female is selected
                },
                label = { Text(text = "Female") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Female, // Use your female icon here
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (isFemaleSelected) Color.Blue else Color.Gray,  // Purple when selected
                    labelColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Age",
                modifier = Modifier,
                color = Color.LightGray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            AccountTextInput(
                text = age,
                onTextChange = { age = it })

        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Email",
                modifier = Modifier,
                color = Color.LightGray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            AccountTextInput(
                text = email,
                onTextChange = { email = it })

        }


    }

}




