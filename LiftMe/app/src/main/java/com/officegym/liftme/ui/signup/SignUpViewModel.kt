package com.officegym.liftme.ui.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {
    private val _signUpUiState = MutableStateFlow(SignUpData())
    val signUpUiState = _signUpUiState.asStateFlow()

    fun uiAction(actions: SignUpActions) {
        when(actions) {
            SignUpActions.Continue -> onContinueClick()
            is SignUpActions.OnValueChange -> onValueChange(actions.value)
        }
    }

    private fun onValueChange(value: String) {
        _signUpUiState.update { it.copy(currentText = value) }
    }

    private fun onContinueClick() {
        // add check if last step
        saveTextFieldValue()
       // var currentStep = _signUpUiState.value.step
        _signUpUiState.update { it.copy(step = ++it.step) }
    }

    private fun saveTextFieldValue() {
        when(SignUpSteps.entries[_signUpUiState.value.step]) {
            SignUpSteps.EMAIL -> { _signUpUiState.update { it.copy(emailAddress = it.currentText) } }
            SignUpSteps.CONFIRMATION_CODE -> { _signUpUiState.update { it.copy(verificationCode = it.currentText) } }
            SignUpSteps.PASSWORD -> { _signUpUiState.update { it.copy(password = it.currentText) } } // add confirmation password
            SignUpSteps.NAME -> { _signUpUiState.update { it.copy(firstName = it.currentText) } } // add lastName
            SignUpSteps.USERNAME -> { _signUpUiState.update { it.copy(username = it.currentText) } }
        }
    }
}
