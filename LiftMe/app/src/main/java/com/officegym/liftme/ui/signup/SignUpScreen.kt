package com.officegym.liftme.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui.theme.LocalLMTheme
import com.officegym.liftme.ui_components.ButtonWithArrow

// Mocked data
@Composable
fun SignUpScreen() {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(LocalLMTheme.current.colors.backgroundBlur, LocalLMTheme.current.colors.background,),
            center = Offset(maxWidth.value /2f, maxHeight.value / 2f),
            radius = maxHeight.value * 2,
            tileMode = TileMode.Clamp
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .background(brush)
            .background(LocalLMTheme.current.colors.background.copy(0.4f))
            .padding(16.dp)) {
            Column {
                StepCompletionText(1, 4)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_step_title_sign_up)))
                Display_md(text = "Enter your email address")
            }
            Column {
                ButtonWithArrow(text = stringResource(id = R.string.continue_btn_text)) {} // on click
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_s)))
                BoxWithConstraints {
                    val width = this.maxWidth / 3
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_xs)),
                    ) {
                        SocialIcon(socialRes = R.drawable.google_icon, modifier = Modifier.width(width)) {}
                        SocialIcon(socialRes = R.drawable.x_icon, modifier = Modifier.width(width)) {}
                        SocialIcon(socialRes = R.drawable.facebook_icon, modifier = Modifier.width(width)) {}
                    }
                }
            }
        }
    }
}