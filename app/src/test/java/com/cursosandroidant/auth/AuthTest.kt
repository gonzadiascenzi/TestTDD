package com.cursosandroidant.auth

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthTest {
    @Test
    fun login_complete_returnTrue(){
        val resultMagic = userAuthentication("ant@gmail.com", "1234")
        assertTrue(resultMagic)
    }
    @Test
    fun login_complete_returnFalse(){
        val resultMagic = userAuthentication("nt@gmail.com", "1234")
        assertFalse(resultMagic)
    }
    @Test
    fun login_emptyEmail_returnFalse(){
        val resultMagic = userAuthentication("", "123e")
        assertFalse(resultMagic)
    }


    /*
    TDD

    @Test
    fun login_nullEmail_returnFalse(){
        val resultMagic = userAuthenticationTDD(null, "1234")
        assertFalse(resultMagic)
    }
    @Test
    fun login_nullPassword_returnFalse(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", null)
        assertFalse(resultMagic)
    }

     */


}