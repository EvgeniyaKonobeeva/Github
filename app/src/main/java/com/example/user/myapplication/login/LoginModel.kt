package com.example.user.myapplication.login

/**
 * Created by Evgeniya on 05.02.2018.
 */
data class LoginModel(val empty: Boolean,
                      val internetError: Boolean,
                      val invalidUser: Boolean,
                      val ErrorText:String,
                      val success: Boolean,
                      val loading: Boolean) {
}