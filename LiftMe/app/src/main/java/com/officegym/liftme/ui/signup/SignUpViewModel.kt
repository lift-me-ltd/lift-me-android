package com.officegym.liftme.ui.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _signUpUiState = MutableStateFlow(SignUpData())
    val signUpUiState = _signUpUiState.asStateFlow()

    fun uiAction(actions: SignUpActions) {
        when (actions) {
            SignUpActions.Continue -> onContinueClick()
            is SignUpActions.OnValueChange -> onValueChange(actions.value)
            SignUpActions.Back -> onBackClick()
        }
    }

    private fun onValueChange(value: String) {
        _signUpUiState.update { it.copy(currentText = value) }
    }

    private fun onContinueClick() {
        // add check if last step
        saveTextFieldValue()
        if (_signUpUiState.value.step < SignUpSteps.entries.size - 1) {
            val currentStep = _signUpUiState.value.step + 1
            _signUpUiState.update { it.copy(step = currentStep) }
        }
    }

    private fun onBackClick() {
        saveTextFieldValue()
        if (_signUpUiState.value.step > 0) {
            val currentStep = _signUpUiState.value.step - 1
            _signUpUiState.update { it.copy(step = currentStep) }
        }
    }

    private fun saveTextFieldValue() {
        when (SignUpSteps.entries[_signUpUiState.value.step]) {
            SignUpSteps.EMAIL -> {
                _signUpUiState.update { it.copy(emailAddress = it.currentText, currentText = "") }
            }

            SignUpSteps.CONFIRMATION_CODE -> {
                _signUpUiState.update { it.copy(verificationCode = it.currentText, currentText = "") }
            }

            SignUpSteps.PASSWORD -> {
                _signUpUiState.update { it.copy(password = it.currentText, currentText = "") }
            } // add confirmation password
            SignUpSteps.NAME -> {
                _signUpUiState.update { it.copy(firstName = it.currentText, currentText = "") }
            } // add lastName
            SignUpSteps.USERNAME -> {
                _signUpUiState.update { it.copy(username = it.currentText, currentText = "") }
            }
        }
    }
}
