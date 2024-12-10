package com.dieghoatc.abreyakmp.android.ui.sreens.auth

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AuthViewModel {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _showPassword = MutableLiveData<Boolean>()
    val showPassword: LiveData<Boolean> = _showPassword

    private val _loginButtonEnable = MutableLiveData<Boolean>()
    val loginButtonEnable: LiveData<Boolean> = _loginButtonEnable

    private val _singUpButtonEnable = MutableLiveData<Boolean>()
    val singUpButtonEnable: LiveData<Boolean> = _singUpButtonEnable

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

    fun onSingUpChanged(name:String, lastName:String, email:String, password:String){
//        _name.value = name
//        _lastName.value = lastName
//        _email.value = email
//        _password.value = password
//        _singUpButtonEnable.value = name.isNotEmpty() && lastName.isNotEmpty() && isValidEmail(email) && isValidPassword(password)
    }

    fun onValidateSamePassword(){

    }
}