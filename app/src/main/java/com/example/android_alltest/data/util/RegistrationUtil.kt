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


object Utils{
    const val key = "24524448-19927c7fcab5ce95562490a8d"
    const val DATABASE_NAME = "shopping_db"
    const val BASE_URL = "https://pixabay.com"

    const val MAX_NAME_LENGTH = 20
    const val MAX_PRICE_LENGTH = 10
}