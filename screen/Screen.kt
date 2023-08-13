package com.inito.assignmentaugweek2.screen

sealed class Screen(val route: String) {
    object SignUp : Screen("sign_up")
    object Info : Screen("info")

    object Home: Screen("home")
    object Settings: Screen("settings")
    object Chat: Screen("chat")
}
