package com.officegym.liftme.ui.signup

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.officegym.liftme.navigation.model.Screen

fun NavGraphBuilder.signUp() {
    navigation(
        startDestination = Screen.Signup.getScreenPath(),
        route = Screen.Signup.getGraphPath()
    ) {
        composable(Screen.Signup.getScreenPath()) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            val signUpData = viewModel.signUpUiState.collectAsState()
            SignUpScreen(signUpData = signUpData.value, uiAction = viewModel::uiAction)
        }
    }
}
