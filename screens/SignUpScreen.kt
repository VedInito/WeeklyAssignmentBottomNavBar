package com.inito.bottomnavigationbar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.inito.bottomnavigationbar.utility.emailMessage
import com.inito.bottomnavigationbar.utility.nameMessage
import com.inito.bottomnavigationbar.utility.passwordMessage
import com.inito.bottomnavigationbar.utility.phoneMessage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavHostController, updateUserInfo: (List<String>) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp) // Adjust the size as needed
        )

        var name by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var phone by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        var buttonPressed by rememberSaveable { mutableStateOf(false) }

        val textBoxColors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            unfocusedLabelColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.LightGray,
            unfocusedIndicatorColor = Color.LightGray,
            containerColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )

        val textBoxModifier = Modifier
            .height(70.dp)
            .width(300.dp)
        val textEntryBackgroundModifier = Modifier.height(50.dp)

        val iconModifier = Modifier.size(20.dp)
        val errorOffset = "\t\t\t "

        Box(modifier = textBoxModifier) {
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(contentAlignment = Alignment.BottomStart) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
                Text("")
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Full name") }
                )
            }
            Box(
                modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = errorOffset + if (buttonPressed || name.isNotEmpty()) nameMessage(name) else "",
                    color = Color.Red.copy(alpha = 0.7f),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left,
                )
            }
        }

        Box(modifier = textBoxModifier) {
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(contentAlignment = Alignment.BottomStart) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                }
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") }
                )
            }
            Box(
                modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = errorOffset + if (buttonPressed || email.isNotEmpty()) emailMessage(email) else "",
                    color = Color.Red.copy(alpha = 0.7f),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

        Box(modifier = textBoxModifier) {
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(contentAlignment = Alignment.BottomStart) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null
                    )
                }
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone Number") }
                )
            }
            Box(
                modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = errorOffset + if (buttonPressed || phone.isNotEmpty()) phoneMessage(phone) else "",
                    color = Color.Red.copy(alpha = 0.7f),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

        Box(modifier = textBoxModifier) {
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(contentAlignment = Alignment.BottomStart) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") }
                )
            }
            Box(
                modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = errorOffset + if (buttonPressed || password.isNotEmpty()) passwordMessage(password) else "",
                    color = Color.Red.copy(alpha = 0.7f),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

        Spacer(Modifier.height(100.dp))

        var toNavigate by remember { mutableStateOf(false) }
        Button(onClick = {
            buttonPressed = true
            val isInfoValid =
                nameMessage(name).isEmpty() && phoneMessage(phone).isEmpty() && passwordMessage(
                    password
                ).isEmpty()

            if (isInfoValid) {
                updateUserInfo(listOf(name, email, phone, password))
                toNavigate = true
                navController.navigate(Screen.Home.route)
            }
        }) { Text("SUBMIT") }

    }
}