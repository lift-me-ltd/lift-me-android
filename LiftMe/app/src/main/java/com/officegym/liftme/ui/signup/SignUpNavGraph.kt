package com.officegym.liftme.ui.signup

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.officegym.liftme.navigation.model.Screen
import com.officegym.liftme.ui.welcome.WelcomeScreen

fun NavGraphBuilder.signUp() {
    navigation(
        startDestination = Screen.Welcome.getScreenPath(),
        route = Screen.Welcome.getGraphPath()
    ) {
        composable(Screen.Welcome.getScreenPath()) {
            WelcomeScreen { }
        }

        composable(Screen.Signup.getScreenPath()) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            val signUpData = viewModel.signUpUiState.collectAsState()
            SignUpScreen(signUpData = signUpData.value, uiAction = viewModel::uiAction)
        }
    }
}
