package com.inito.assignmentaugweek2.ui_components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun UIcomponents() {
    var currentBackgroundColor by remember { mutableStateOf(Color(Random.nextLong(0xFFFFFFFF))) }
    var previousBackgroundColor by remember { mutableStateOf(Color(Random.nextLong(0xFFFFFFFF))) }

    var progressBarProgress by remember { mutableStateOf(0f) }
    val animateProgress by animateFloatAsState(
        targetValue = progressBarProgress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = ""
    )

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState) {
                Snackbar(modifier = Modifier.padding(12.dp), action = {
                    TextButton(onClick = {
                        val tmp = currentBackgroundColor
                        currentBackgroundColor = previousBackgroundColor
                        previousBackgroundColor = tmp
                        it.dismiss()
                    }) {
                        Text("undo")
                    }
                }, dismissAction = {
                    IconButton(onClick = {
                        it.dismiss()
                    }) {
                        Icon(Icons.Outlined.Close, contentDescription = "lsls")
                    }
                }) {
                    Text(it.visuals.message)
                }
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    previousBackgroundColor = currentBackgroundColor
                    currentBackgroundColor = Color(Random.nextLong(0xFFFFFFFF))
                    progressBarProgress += 0.1f

                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "color changed",
                            actionLabel = "undo",
                            withDismissAction = true,
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                elevation = FloatingActionButtonDefaults.elevation(5.dp),
                containerColor = Color.Green
            ) {
                Icon(Icons.Outlined.Add, "Localized description")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(color = currentBackgroundColor)
        ) {
            var openBottomSheet by remember { mutableStateOf(false) }
            IconButton(onClick = {
                currentBackgroundColor = Color(Random.nextLong(0xFFFFFFFF))
                openBottomSheet = !openBottomSheet
            }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = animateProgress,
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text("${minOf((progressBarProgress * 100).toInt(), 100)}")
            }

            val sheetState =
                rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden,
                    confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
                )

            val coroutineScope = rememberCoroutineScope()

            BackHandler(sheetState.isVisible) {
                coroutineScope.launch { sheetState.hide() }
            }

            ModalBottomSheetLayout(
                sheetState = sheetState,
                sheetContent = {

                    Column(
                        modifier = Modifier.padding(32.dp)
                    ) {
                        Text(
                            text = "Bottom sheet",
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Click outside the bottom sheet to hide it",
                        )
                    }
                },
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 24.dp)
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome to bottom sheet playground!",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                if (sheetState.isVisible) sheetState.hide()
                                else sheetState.show()
                            }
                        }
                    ) {
                        Text(text = "Click to show bottom sheet")
                    }
                }
            }

            var openDialog by remember { mutableStateOf(true) }

            if (openDialog) {
                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onDismissRequest.
                        openDialog = false
                    },
                    title = {
                        Text(text = "Title")
                    },
                    text = {
                        Text(text = "Turned on by default")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                openDialog = false
                            }
                        ) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                openDialog = false
                            }
                        ) {
                            Text("Dismiss")
                        }
                    }
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(100.dp))
                    Row() {

                        Button(onClick = { openDialog = !openDialog }) {
                            Text("toggleDialog")
                        }

                        val checkedState = remember { mutableStateOf(true) }
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it }
                        )

                        AssistChip(
                            onClick = { /* Do something! */ },
                            label = { Text("Assist Chip") },
                            leadingIcon = {
                                Icon(
                                    Icons.Filled.Settings,
                                    contentDescription = "Localized description",
                                    Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )

                        var state by remember { mutableStateOf(true) }

                        RadioButton(
                            selected = state,
                            onClick = { state = true },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            }
                        )
                        RadioButton(
                            selected = !state,
                            onClick = { state = false },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(100.dp))
                    Column {
                        var sliderPosition by remember { mutableFloatStateOf(0f) }
                        Text(text = sliderPosition.toString())
//                        Slider(
//                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
//                            value = sliderPosition,
//                            onValueChange = { sliderPosition = it })
                        Text(text = sliderPosition.toString())
                        Slider(
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            value = sliderPosition,
                            onValueChange = { sliderPosition = it },
                            valueRange = 0f..100f,
                            onValueChangeFinished = {
                                // launch some business logic update with the state you hold
                                // viewModel.updateSelectedSliderValue(sliderPosition)
                            },
                            steps = 4
                        )

                        var checked by remember { mutableStateOf(true) }

                        Switch(
                            modifier = Modifier.semantics { contentDescription = "Demo with icon" },
                            checked = checked,
                            onCheckedChange = { checked = it },
                            thumbContent = if (checked) {
                                {
                                    Icon(
                                        imageVector = Icons.Filled.Check,
                                        contentDescription = null,
                                        modifier = Modifier.size(SwitchDefaults.IconSize),
                                    )
                                }
                            } else {
                                null
                            }
                        )
                    }
                }
            }
        }
    }
}

suspend fun getUser(
    duration: Long = 5000,
    maxRandomStringLength: Int = 10,
): String {
    val name: String?
    delay(duration)
    val randomStringLength = Random.nextInt(0, maxRandomStringLength)
    name = (1..randomStringLength)
        .map { ('a'..'z').random() }
        .joinToString("")
    return name
}

@Composable
fun ShowRandomString() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var name by remember { mutableStateOf<String?>(null) }
        LaunchedEffect(true) {
            name = getUser()
        }

        if (name != null)
            Text(text = name ?: "")
        else
            CircularProgressIndicator()
    }
}

@Preview
@Composable
fun UIPreview() {
    ShowRandomString()
}