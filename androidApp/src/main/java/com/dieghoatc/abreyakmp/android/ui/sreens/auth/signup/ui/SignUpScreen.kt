package com.dieghoatc.abreyakmp.android.ui.sreens.auth.signup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dieghoatc.abreyakmp.android.ui.components.EmailField
import com.dieghoatc.abreyakmp.android.ui.components.InputTextField
import com.dieghoatc.abreyakmp.android.ui.components.PasswordField
import com.dieghoatc.abreyakmp.android.ui.components.PrimaryButton
import com.dieghoatc.abreyakmp.android.ui.sreens.auth.login.ui.HeaderImage

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff101820))
    ) {
        signUp(
            Modifier
                .align(Alignment.Center)
                .padding(24.dp),
            signUpViewModel,
            navController
        )
    }
}

@Composable
fun signUp(
    modifier: Modifier,
    signUpViewModel: SignUpViewModel,
    navController: NavController
) {

    val name: String by signUpViewModel.name.observeAsState(initial = "")
    val lastName: String by signUpViewModel.lastName.observeAsState(initial = "")
    val email: String by signUpViewModel.email.observeAsState(initial = "")
    val password: String by signUpViewModel.password.observeAsState(initial = "")
    val checkPassword: String by signUpViewModel.checkPassword.observeAsState(initial = "")
    val showPassword: Boolean by signUpViewModel.showPassword.observeAsState(initial = false)
    val singUpButtonEnable: Boolean by signUpViewModel.singUpButtonEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        HeaderImage(
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(110.dp)
        )
        Spacer(Modifier.padding(16.dp))
        InputTextField(
            title = "Nombre",
            name,
            onTextFieldChanged = { signUpViewModel.handleSingUp(it, lastName, email, password, checkPassword) })
        Spacer(modifier = Modifier.padding(8.dp))
        InputTextField(
            title = "Apellido",
            lastName,
            onTextFieldChanged = { signUpViewModel.handleSingUp(name, it, email, password, checkPassword) })
        Spacer(Modifier.padding(8.dp))
        EmailField(email, onTextFieldChanged = { signUpViewModel.handleSingUp(name, lastName, it, password, checkPassword) })
        Spacer(Modifier.padding(8.dp))
        PasswordField(
            title = "Contraseña",
            password = password,
            showPassword = showPassword,
            onTextFieldChanged = {signUpViewModel.handleSingUp(name, lastName, email, it, checkPassword)},
            onShowPassword = { signUpViewModel.onShowPasswordChanged(it) })
        Spacer(Modifier.padding(8.dp))
        PasswordField(
            title = "Confirmar contraseña",
            password = checkPassword,
            showPassword = showPassword,
            onTextFieldChanged = {signUpViewModel.handleSingUp(name, lastName, email, password,it)},
            onShowPassword = { signUpViewModel.onShowPasswordChanged(it) })
        Spacer(Modifier.padding(16.dp))
        PrimaryButton(title = "Registrar", singUpButtonEnable) { signUpViewModel.onFormSubmitSuccess(navController) }
    }
}