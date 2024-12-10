package com.dieghoatc.abreyakmp.android.ui.sreens.auth.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dieghoatc.abreyakmp.android.R
import com.dieghoatc.abreyakmp.android.ui.components.EmailField
import com.dieghoatc.abreyakmp.android.ui.components.PasswordField
import com.dieghoatc.abreyakmp.android.ui.components.PrimaryButton
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xff101820))
    ) {
        Login(
            Modifier
                .align(Alignment.Center)
                .padding(16.dp), loginViewModel, navController
        )
    }
}


@Composable
fun Login(
    modifier: Modifier,
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val showPassword: Boolean by loginViewModel.showPassword.observeAsState(initial = false)
    val loginButtonEnable: Boolean by loginViewModel.loginButtonEnable.observeAsState(initial = false)
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier) {
            HeaderImage(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(110.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email) { loginViewModel.onLoginChanged(it, password) }
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(
                title = "Contraseña",
                password = password,
                showPassword = showPassword,
                onTextFieldChanged = { loginViewModel.onLoginChanged(email, it) },
                onShowPassword = { loginViewModel.onShowPasswordChanged(it) })

            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End), navController)
            Spacer(modifier = Modifier.padding(8.dp))
            PrimaryButton(
                title = "Iniciar sesión",
                loginButtonEnable
            ) { coroutineScope.launch { loginViewModel.onLoginSelected(navController) } }
            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                CreateAccount()
                Spacer(modifier = Modifier.padding(4.dp))
                NewAccount(navController)

            }
        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_abreya),
        contentDescription = "abreya logo",
        modifier = modifier
    )
}

@Composable
fun ForgotPassword(modifier: Modifier, navController: NavController) {
    Text(
        text = "¿Olvidaste la contraseña?",
        modifier = modifier.clickable { navController.navigate("SingUpScreen") },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFfdffc1)
    )
}

@Composable
fun CreateAccount() {
    Text(
        text = "¿No tienes cuenta?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFfdffc1)
    )
}

@Composable
fun NewAccount(navController: NavController) {
    Text(
        text = "Registrate",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFd19f00),
        modifier = Modifier.clickable { navController.navigate("signup") }
    )
}