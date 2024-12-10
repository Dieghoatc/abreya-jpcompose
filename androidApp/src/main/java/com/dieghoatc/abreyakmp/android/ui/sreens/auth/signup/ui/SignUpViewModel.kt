package com.dieghoatc.abreyakmp.android.ui.sreens.auth.signup.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController

class SignUpViewModel {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _checkPassword = MutableLiveData<String>()
    val checkPassword: LiveData<String> = _checkPassword

    private val _showPassword = MutableLiveData<Boolean>()
    val showPassword: LiveData<Boolean> = _showPassword

    private val _singUpButtonEnable = MutableLiveData<Boolean>()
    val singUpButtonEnable: LiveData<Boolean> = _singUpButtonEnable

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length > 6

    fun onShowPasswordChanged(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun handleSingUp(name: String, lastName: String, email: String, password: String, checkPassword: String) {
        _name.value = name
        _lastName.value = lastName
        _email.value = email
        _password.value = password
        _checkPassword.value = checkPassword
        _singUpButtonEnable.value = name.isNotEmpty() && lastName.isNotEmpty() && isValidEmail(email) && isValidPassword(password) && isValidPassword(checkPassword)
    }

    fun onFormSubmitSuccess(navController: NavController){
        navController.navigate("home")
    }
}