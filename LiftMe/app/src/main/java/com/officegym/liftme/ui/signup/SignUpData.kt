package com.officegym.liftme.ui.signup

data class SignUpData(
    val emailAddress: String = "",
    val verificationCode: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val username: String = "",
    val currentText: String = "",
    var step: Int = 0
)

sealed interface SignUpActions{
    data object Continue: SignUpActions
    data class OnValueChange(val value: String): SignUpActions
}
