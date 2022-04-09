package com.cursosandroidant.auth

/****
 * Project: Auth
 * From: com.cursosandroidant.auth
 * Created by Alain Nicolás Tello on 14/12/21 at 12:05
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/

fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {

    if(email == null && password == null) return AuthEvent.NULL_FORM

    if (email!!.isEmpty() && password!!.isEmpty()) return AuthEvent.EMPTY_FORM
    if (email!!.isEmpty()) return AuthEvent.EMPTY_EMAIL
    if (password!!.isEmpty()) return AuthEvent.EMPTY_PASSWORD
    if (password.length != 4) return AuthEvent.LENGTH_PASSWORD

    val passwordNumeric = password.toIntOrNull()
    if ( !isEmailValid(email) && passwordNumeric == null) return AuthEvent.INVALID_USER
    if (!isEmailValid(email)) return AuthEvent.INVALID_EMAIL
    if (passwordNumeric == null) return AuthEvent.INVALID_PASS



    return if (email == "ant@gmail.com" && password == "1234") {
        AuthEvent.USER_EXIST
    }
    else AuthEvent.NOT_USER_FOUND

}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}


