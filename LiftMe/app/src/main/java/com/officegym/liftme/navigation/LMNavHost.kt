package com.officegym.liftme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.officegym.liftme.ui.signup.signUp

@Composable
fun LMNavHost(
    navigator: Navigator,
    bottomNavStartDestination: String
) {
    NavHost(
        navController = navigator.getNavController(),
        startDestination = navigator.getStartDestination()
    ) {
        signUp()
    }
}
