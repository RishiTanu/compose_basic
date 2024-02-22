package com.example.jetpack_compose.ui.activity.auth

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.ui.activity.home.DashboardScreen
import com.example.jetpack_compose.ui.activity.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splashScreen") {
        composable("splashScreen") { SplashScreen(navController) }
        composable("loginScreen") { LoginScreen(navController) }
        composable("dashboardScreen") { DashboardScreen(navController) }
        composable("signUpScreen") { SignUpAuth(navController) }
        composable("forgotScreen") { ForgetPasswordAuth(navController) }
    }
}
