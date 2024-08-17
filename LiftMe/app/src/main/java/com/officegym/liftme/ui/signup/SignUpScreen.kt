package com.officegym.liftme.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.officegym.liftme.R
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui_components.ButtonWithArrow

// Mocked data
@Composable
fun SignUpScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column {
            StepCompletionText(1, 4)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_step_title_sign_up)))
            Display_md(text = "Enter your email address")
        }
        Column {
            ButtonWithArrow(text = stringResource(id = R.string.continue_btn_text)) {} // on click
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_s)))
            Row(modifier = Modifier.fillMaxWidth()) {
                SocialIcon(socialRes = R.drawable.google_icon, socialTitle = "google")
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_xs)))
                SocialIcon(socialRes = R.drawable.x_icon, socialTitle = "x")
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_xs)))
                SocialIcon(socialRes = R.drawable.facebook_icon, socialTitle = "facebook")
            }
        }
    }
}