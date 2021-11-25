package com.example.android_alltest

import com.example.android_alltest.data.util.RegistrationUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `if empty username password and confirmpassword return false`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty username returns false`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "Enzo",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username aldeary exist return false`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "Carls",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "Philip",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password return false`(){
        val result =  RegistrationUtil.validateRegistrationInput(
            "Philip",
            "a",
            "a"
        )
        assertThat(result).isFalse()
    }
}