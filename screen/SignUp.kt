package com.inito.assignmentaugweek2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.inito.assignmentaugweek2.utility.emailMessage
import com.inito.assignmentaugweek2.utility.nameMessage
import com.inito.assignmentaugweek2.utility.passwordMessage
import com.inito.assignmentaugweek2.utility.phoneMessage

@Composable
fun SignUp(
    navController: NavHostController, updateUserInfo: (List<String>) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF2EDED), Color(0xFFF9F9F9))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Head()

        var nameFieldEntry by rememberSaveable { mutableStateOf("") }
        var emailFieldEntry by rememberSaveable { mutableStateOf("") }
        var phoneFieldEntry by rememberSaveable { mutableStateOf("") }
        var passwordFieldEntry by rememberSaveable { mutableStateOf("") }

        var isSubmitButtonPressedAtLeastOnce by rememberSaveable { mutableStateOf(false) }

        InputField(
            fieldEntry = nameFieldEntry,
            updateField = { nameFieldEntry = it },
            isSubmitButtonPressedAtLeastOnce = isSubmitButtonPressedAtLeastOnce,
            errorMessage = nameMessage(nameFieldEntry),
            inputLabel = "Full Name",
            iconImageVector = Icons.Default.AccountCircle
        )

        InputField(
            fieldEntry = emailFieldEntry,
            updateField = { emailFieldEntry = it },
            isSubmitButtonPressedAtLeastOnce = isSubmitButtonPressedAtLeastOnce,
            errorMessage = emailMessage(emailFieldEntry),
            inputLabel = "Email",
            iconImageVector = Icons.Default.Email
        )

        InputField(
            fieldEntry = phoneFieldEntry,
            updateField = { phoneFieldEntry = it },
            isSubmitButtonPressedAtLeastOnce = isSubmitButtonPressedAtLeastOnce,
            errorMessage = phoneMessage(phoneFieldEntry),
            inputLabel = "Phone Number",
            iconImageVector = Icons.Default.Phone
        )

        InputField(
            fieldEntry = passwordFieldEntry,
            updateField = { passwordFieldEntry = it },
            isSubmitButtonPressedAtLeastOnce = isSubmitButtonPressedAtLeastOnce,
            errorMessage = passwordMessage(passwordFieldEntry),
            inputLabel = "Password",
            iconImageVector = Icons.Default.Lock,
            isPasswordField = true
        )

        Spacer(Modifier.height(100.dp))

        var toNavigate by remember { mutableStateOf(false) }
        Button(
            onClick = {
                isSubmitButtonPressedAtLeastOnce = true
                val isInfoValid =
                    nameMessage(nameFieldEntry).isEmpty() && phoneMessage(phoneFieldEntry).isEmpty() && passwordMessage(
                        passwordFieldEntry
                    ).isEmpty()

                if (isInfoValid) {
                    updateUserInfo(
                        listOf(
                            nameFieldEntry, emailFieldEntry, phoneFieldEntry, passwordFieldEntry
                        )
                    )
                    toNavigate = true
                    navController.navigate(Screen.Info.route)
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE63946)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp)
        ) { Text("SUBMIT") }

    }
}

@Composable
fun Head() {
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .padding(12.dp)
            .clip(CircleShape),
        tint = Color.DarkGray
    )
    Spacer(modifier = Modifier.height(60.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    fieldEntry: String,
    updateField: (String) -> Unit,
    isSubmitButtonPressedAtLeastOnce: Boolean,
    errorMessage: String,
    inputLabel: String,
    iconImageVector: ImageVector,
    isPasswordField: Boolean = false
) {
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
    val errorOffset = "\t\t\t "

    Box(modifier = textBoxModifier) {
        Row(
            modifier = Modifier.matchParentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(contentAlignment = Alignment.BottomStart) {
                Icon(
                    imageVector = iconImageVector, contentDescription = null,
                    tint = Color.DarkGray
                )
            }
            Text("")
            if (isPasswordField) {
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    value = fieldEntry,
                    onValueChange = { updateField(it) },
                    label = { Text(inputLabel) })
            } else {
                TextField(modifier = textEntryBackgroundModifier,
                    colors = textBoxColors,
                    value = fieldEntry,
                    onValueChange = { updateField(it) },
                    label = { Text(inputLabel) }
                )
            }
        }
        Box(
            modifier = Modifier.matchParentSize(), contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = errorOffset + if (isSubmitButtonPressedAtLeastOnce || fieldEntry.isNotEmpty()) errorMessage else "",
                color = Color.Red.copy(alpha = 0.7f),
                fontSize = 10.sp,
                textAlign = TextAlign.Left,
            )
        }
    }
}