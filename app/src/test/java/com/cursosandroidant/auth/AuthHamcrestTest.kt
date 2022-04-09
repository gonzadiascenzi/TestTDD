package com.cursosandroidant.auth


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.lang.Exception
import java.lang.NullPointerException

class AuthHamcrestTest {

    //given-when-then

    @Test
    fun loginUser_correctData_returnsSuccessEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(resultMagic) )

    }

    @Test
    fun loginUser_wrongData_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("nt@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_FOUND, `is`(resultMagic))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(resultMagic))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(resultMagic))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(resultMagic))
    }

    @Test
    fun loginUser_incorrectEmail_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("nt@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(resultMagic))
    }

    @Test
    fun loginUser_incorrectPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmail.com", "123e")
        assertThat(AuthEvent.INVALID_PASS, `is`(resultMagic))
    }

    @Test
    fun loginUser_incorrectUser_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmailcom", "123e")
        assertThat(AuthEvent.INVALID_USER, `is`(resultMagic))
    }

    @Test(expected = NullPointerException::class)
    fun loginUser_nullEmail_returnsException(){
        val resultMagic = userAuthenticationTDD(null, "123e")
        assertThat(AuthEvent.NULL_EMAIL, `is`(resultMagic))
    }

    @Test
    fun loginUser_nullForm_returnsException(){
        try {
            val resultMagic = userAuthenticationTDD(null, null)
            assertThat(AuthEvent.NULL_FORM, `is`(resultMagic))

        } catch (e: Exception){
            val it = null
            assertThat(AuthEvent.NULL_FORM, `is`(it))
        }
    }
    @Ignore("Etiqueta por si falta un requisito del cliente...")
    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent(){
        val resultMagic = userAuthenticationTDD("ant@gmailcom", "123")
        assertThat(AuthEvent.LENGTH_PASSWORD, `is`(resultMagic))
    }
}