package com.officegym.liftme.ui.signup

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.officegym.liftme.R

enum class SignUpSteps(val value: SignUpStepsData) {
    EMAIL(
        SignUpStepsData(
            title = R.string.email_address_title,
            hint = R.string.email_address,
            placeholder = R.string.email_address_placeholder,
            icon = R.drawable.mail_icon
        )
    ),
    CONFIRMATION_CODE(
        SignUpStepsData(
            title = R.string.confirmation_code_title,
            hint = R.string.confirmation_code
        )
    ),
    PASSWORD(
        SignUpStepsData(
            title = R.string.password_title,
            hint = R.string.password,
            placeholder = R.string.password_placeholder,
            icon = R.drawable.lock_icon
        )
    ),
    NAME(
       SignUpStepsData(
           title = R.string.name_title,
           hint = R.string.what_is_your_name
       )
    ),
    USERNAME(
        SignUpStepsData(
            title = R.string.username_title,
            hint = R.string.how_does_this_sound,
        )
    ),
}

data class SignUpStepsData(
    @StringRes val title: Int,
    @StringRes val hint: Int,
    @StringRes val placeholder: Int? = null,
    @DrawableRes val icon: Int? = null
)
