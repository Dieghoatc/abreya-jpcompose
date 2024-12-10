package com.dieghoatc.abreyakmp.android.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dieghoatc.abreyakmp.android.data.model.TechnicalModel
import com.dieghoatc.abreyakmp.android.ui.sreens.auth.login.ui.LoginScreen
import com.dieghoatc.abreyakmp.android.ui.sreens.auth.login.ui.LoginViewModel
import com.dieghoatc.abreyakmp.android.ui.sreens.home.HomeScreen
import com.dieghoatc.abreyakmp.android.ui.sreens.technical.TechnicalScreen
import com.dieghoatc.abreyakmp.android.ui.sreens.auth.signup.ui.SignUpScreen
import com.dieghoatc.abreyakmp.android.ui.sreens.auth.signup.ui.SignUpViewModel
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {
        composable(Route.Login.route) {
            val loginViewModel = LoginViewModel()
            LoginScreen(loginViewModel, navController)
        }
        composable(Route.SignUp.route) {
            val signUpViewModel = SignUpViewModel()
            SignUpScreen(signUpViewModel, navController)
        }
        composable(Route.Home.route) {
            HomeScreen(navController)
        }
        composable(
            Route.Technical.route,
            arguments = listOf(navArgument("technicalModelJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val technicalModelJson = backStackEntry.arguments?.getString("technicalModelJson") ?: ""
            val technical = Json.decodeFromString<TechnicalModel>(technicalModelJson)

            TechnicalScreen(technical)
        }
    }
}
