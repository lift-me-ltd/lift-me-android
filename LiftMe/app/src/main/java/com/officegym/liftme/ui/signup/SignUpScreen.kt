package com.officegym.liftme.ui.signup

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
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
import com.officegym.liftme.ui_components.VerificationCodeUI

// Mocked data
@Composable
fun SignUpScreen(
    signUpData: SignUpData,
    uiAction: (SignUpActions) -> Unit,
) {
    BackHandler(enabled = signUpData.step != SignUpSteps.EMAIL.ordinal) {
        uiAction(SignUpActions.Back)
    }

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
            val configuration = LocalConfiguration.current
            val screenWidth = configuration.screenWidthDp.dp - 32.dp
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
                StepCompletionText(signUpData.step.inc(), SignUpSteps.entries.size)
                Spacer(modifier = Modifier.height(SignUpFlowSpacing.STEP_TITLE_SPACING))
                Display_md(text = stringResource(id = SignUpSteps.entries[signUpData.step].value.title))
            }
            Column(
                modifier = Modifier.constrainAs(input) {
                    bottom.linkTo(parent.bottom)
                }
            ) {
                if (SignUpSteps.entries[signUpData.step] == SignUpSteps.NAME) {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        AuthTextFieldUi(
                            hint = stringResource(id = R.string.what_is_your_name),
                            onTextChanged = { uiAction(SignUpActions.OnValueChange(it)) },
                            text = signUpData.currentText,
                            placeholder = stringResource(id = R.string.first_name_placeholder),
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    LocalLMTheme.current.colors.strokePrimary,
                                    RoundedCornerShape(
                                        topStart = 12.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 0.dp
                                    )
                                )
                                .width(screenWidth / 2)
                        )
                        AuthTextFieldUi(
                            onTextChanged = { uiAction(SignUpActions.OnLastNameChange(it)) },
                            text = signUpData.lastName,
                            placeholder = stringResource(id = R.string.last_name_placeholder),
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    LocalLMTheme.current.colors.strokePrimary,
                                    RoundedCornerShape(
                                        topStart = 0.dp, topEnd = 12.dp, bottomStart = 0.dp, bottomEnd = 12.dp
                                    )
                                )
                                .width(screenWidth / 2)
                        )
                    }
                } else if (SignUpSteps.entries[signUpData.step] == SignUpSteps.CONFIRMATION_CODE) {
                    val width = (screenWidth - (5*8).dp) / 6
                    VerificationCodeUI(width)
                } else {
                    AuthTextFieldUi(
                        hint = stringResource(id = SignUpSteps.entries[signUpData.step].value.hint),
                        onTextChanged = { uiAction(SignUpActions.OnValueChange(it)) },
                        text = signUpData.currentText,
                        placeholder = SignUpSteps.entries[signUpData.step].value.placeholder?.let { stringResource(id = it) },
                        icon = SignUpSteps.entries[signUpData.step].value.icon,
                        isPassword = SignUpSteps.entries[signUpData.step] == SignUpSteps.PASSWORD,
                        isEmail = SignUpSteps.entries[signUpData.step] == SignUpSteps.EMAIL
                    )
                }
                if (SignUpSteps.entries[signUpData.step] == SignUpSteps.PASSWORD) {
                    Spacer(modifier = Modifier.height(Spacings.SPACING_XL))
                    AuthTextFieldUi(
                        hint = stringResource(id = R.string.conform_your_password),
                        onTextChanged = { uiAction(SignUpActions.OnConfirmPasswordChange(it)) },
                        text = signUpData.confirmPassword,
                        placeholder = stringResource(id = R.string.password_confirm_placeholder),
                        icon = R.drawable.lock_icon,
                        isPassword = true
                    )
                }
                Spacer(modifier = Modifier.height(Spacings.SPACING_XL))
                ButtonWithArrow(text = stringResource(id = R.string.continue_btn_text)) { uiAction(SignUpActions.Continue) }
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