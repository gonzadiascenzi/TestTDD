package com.cursosandroidant.auth

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.lang.Exception
import java.lang.NullPointerException

class AuthTDDTest {

    private var email: String? = null
    private var password: String? = null
    @Before
    fun setup(){
        email = "ant@gmail.com"
        password = "1234"
        //Pruebas inversas
    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.USER_EXIST, resultMagic)
    }

    @Test
    fun login_completeFrom_existUser_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("nt@gmail.com", "1234")
        assertEquals(AuthEvent.NOT_USER_FOUND, resultMagic)
    }

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("", "1234")
        assertEquals(AuthEvent.EMPTY_EMAIL, resultMagic)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "")
        assertEquals(AuthEvent.EMPTY_PASSWORD, resultMagic)
    }

    @Test
    fun login_emptyForm_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("", "")
        assertEquals(AuthEvent.EMPTY_FORM, resultMagic)
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("nt@gmailcom", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, resultMagic)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "123e")
        assertEquals(AuthEvent.INVALID_PASS, resultMagic)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "1234")
        assertEquals(AuthEvent.INVALID_USER, resultMagic)
    }

    @Test (expected = NullPointerException::class)
    fun login_nullEmail_returnsException(){
        val resultMagic = userAuthenticationTDD(null, "123e")
        assertEquals(AuthEvent.NULL_EMAIL, resultMagic)
    }

    @Test
    fun login_nullForm_returnsException(){
        try {
            val resultMagic = userAuthenticationTDD(null, null)
            assertEquals(AuthEvent.NULL_FORM, resultMagic)

        } catch (e: Exception){
            val it = null
            assertEquals(AuthEvent.NULL_FORM, it)
        }
    }
    //@Ignore("Etiqueta por si falta un requisito del cliente...")
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmailcom", "12345")
        assertEquals(AuthEvent.LENGTH_PASSWORD, resultMagic)
    }




    /*


    login_nullEmail_returnsException
    login_nullPassword_returnsException

    */
}