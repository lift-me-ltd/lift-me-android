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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.SignUpFlowSpacing
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui.theme.LocalLMTheme
import com.officegym.liftme.ui_components.AuthTextFieldUi
import com.officegym.liftme.ui_components.ButtonWithArrow

// Mocked data
@Composable
fun SignUpScreen(
    signUpData: SignUpData,
    uiAction: (SignUpActions) -> Unit
) {
    BoxWithConstraints {
        val maxWidth = maxWidth
        val maxHeight = maxHeight
        val brush = Brush.radialGradient(
            colors = listOf(LocalLMTheme.current.colors.backgroundBlur, LocalLMTheme.current.colors.background),
            center = Offset(maxWidth.value, maxHeight.value / 2f),
            radius = maxHeight.value + maxHeight.value * 0.5f,
            tileMode = TileMode.Clamp
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
                .background(LocalLMTheme.current.colors.background.copy(0.6f))
                .padding(16.dp)
        ) {
            val (progressBar, title, input) = createRefs()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(progressBar) { top.linkTo(parent.top) }
            ) {
                SignUpProgress(
                    options = SignUpSteps.entries.map { it.value.hint },
                    selectedOption = SignUpSteps.entries[signUpData.step].value.hint,
                    width = ((maxWidth / SignUpSteps.entries.size) - (2 * SignUpSteps.entries.size).dp)
                )
                Spacer(modifier = Modifier.height(Spacings.SPACING_XXL))
                SignUpBack { uiAction(SignUpActions.Back) }
            }
            Column(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(progressBar.bottom)
                    bottom.linkTo(input.top)
                    start.linkTo(parent.start)
                }
            ) {
                StepCompletionText(1, 4)
                Spacer(modifier = Modifier.height(SignUpFlowSpacing.STEP_TITLE_SPACING))
                Display_md(text = stringResource(id = SignUpSteps.entries[signUpData.step].value.title))
            }
            Column(
                modifier = Modifier.constrainAs(input) {
                    bottom.linkTo(parent.bottom)
                }
            ) {
                AuthTextFieldUi(
                    hint = stringResource(id = SignUpSteps.entries[signUpData.step].value.hint),
                    onTextChanged = { uiAction(SignUpActions.OnValueChange(it)) },
                    text = signUpData.currentText,
                    placeholder = SignUpSteps.entries[signUpData.step].value.placeholder?.let { stringResource(id = it) },
                    icon = R.drawable.mail_icon,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(Spacings.SPACING_XL))
                ButtonWithArrow(text = stringResource(id = R.string.continue_btn_text)) { uiAction(SignUpActions.Continue)}
                Spacer(modifier = Modifier.height(Spacings.SPACING_MD))
                BoxWithConstraints {
                    val width = this.maxWidth / 3
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Spacings.SPACING_XS),
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