package com.example.android_alltest.data.util

object RegistrationUtil {

    private val existingUser = listOf("Enzo", "Carls")
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean{

        if(username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty())
            return false
        if(password != confirmedPassword)
            return false

        if(username in existingUser)
            return false

        if(password.count{it.isDigit()} < 2)
            return false

        return true

    }
}