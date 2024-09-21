package com.officegym.liftme.ui.signup

import com.officegym.liftme.R

enum class SignUpSteps(val value: Int) {
    EMAIL(R.string.email_address),
    CONFIRMATION_CODE(R.string.confirmation_code),
    PASSWORD(R.string.password),
    NAME(R.string.what_is_your_name),
    USERNAME(R.string.how_does_this_sound),
}
