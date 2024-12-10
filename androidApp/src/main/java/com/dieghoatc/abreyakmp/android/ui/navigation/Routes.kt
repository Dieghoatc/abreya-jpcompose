package com.dieghoatc.abreyakmp.android.ui.navigation

sealed class Route(
    val route: String
) {
    data object Login : Route("login")
    data object SignUp : Route("signup")
    data object Home : Route("home")
    data object Technical : Route("technical/{technicalModelJson}")
}