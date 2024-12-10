package com.dieghoatc.abreyakmp.android.ui.sreens.auth.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _showPassword = MutableLiveData<Boolean>()
    val showPassword: LiveData<Boolean> = _showPassword

    private val _loginButtonEnable = MutableLiveData<Boolean>()
    val loginButtonEnable: LiveData<Boolean> = _loginButtonEnable

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean = password.length > 6

    fun onShowPasswordChanged(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginButtonEnable.value = isValidEmail(email) && isValidPassword(password)
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    suspend fun onLoginSelected(navController: NavController) {
        _isLoading.value = true
        delay(2000)
        navController.navigate("home")
        _isLoading.value = false
    }
}