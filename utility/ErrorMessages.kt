package com.inito.bottomnavigationbar.utility

fun nameMessage(name: String) =
    if (name.isEmpty())
        "\tname cannot be empty"
    else
        ""

fun emailMessage(email: String) =
    when {
        email.all { it != '@' } -> "email should contain @"

        (email.length < 4 ||
                email.substring(email.lastIndex - 3) != ".com")
        -> "email should end with `.com`"

        else -> ""
    }

fun phoneMessage(phone: String) =
    when {
        phone.any { !it.isDigit() }
        -> "phone number should only contain digits"

        phone.length != 10
        -> "phone number should be 10 digits long"

        else -> ""
    }

fun passwordMessage(password: String) =
    when {
        password.length < 8
        -> "password should contain at least 8 characters"

        password.all { !it.isUpperCase() }
        -> "password should contain at least one capital letter"

        password.all { it.isLetterOrDigit() }
        -> "password should contain at least one special character"

        else -> ""
    }