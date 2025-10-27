package com.officegym.liftme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.officegym.liftme.ui.signup.SignUpScreen
import com.officegym.liftme.ui.signup.SignUpViewModel
import com.officegym.liftme.ui.welcome.WelcomeScreen

@Composable
fun LMNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "WELCOME",
    ) {
        composable("WELCOME") {
            WelcomeScreen { navController.navigate("SIGN_UP") }
        }

        composable("SIGN_UP") {
            val viewModel = hiltViewModel<SignUpViewModel>()
            val signUpData = viewModel.signUpUiState.collectAsState()
            SignUpScreen(signUpData = signUpData.value, uiAction = viewModel::uiAction)
        }
    }
}