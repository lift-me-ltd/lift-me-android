package com.officegym.liftme.ui.signup

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.RoundedCornerConstants
import com.officegym.liftme.ui.constants.SignUpFlowSpacing
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun SocialIcon(
    @DrawableRes socialRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .border(1.dp, LocalLMTheme.current.colors.textSecondary, RoundedCornerShape(16.dp))
            .padding(
                vertical = SignUpFlowSpacing.SOCIAL_ICON_VERTICAL_SPACING
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = socialRes), contentDescription = "social")
    }
}

@Composable
fun StepCompletionText(
    currentStep: Int,
    totalSteps: Int,
) {
    Text_md(
        text = stringResource(id = R.string.step_completion, currentStep, totalSteps),
        textColor = LocalLMTheme.current.colors.textSecondary
    )
}

@Composable
fun SignUpProgress(
    @StringRes options: List<Int>,
    @StringRes selectedOption: Int,
    width: Dp,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        options.forEach {
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width(width)
                    .clip(RoundedCornerShape(RoundedCornerConstants.ROUNDED_CORNER_1))
                    .background(
                        if (it == selectedOption) {
                            LocalLMTheme.current.colors.white
                        } else {
                            LocalLMTheme.current.colors.white.copy(0.2f)
                        }
                    )
            )
            Spacer(modifier = Modifier.width(Spacings.SPACING_XS))
        }
    }
}

@Composable
fun SignUpBack(onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Row(Modifier.clickable { onClick() }) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(Spacings.SPACING_XXS))
            Text_md(text = stringResource(id = R.string.back), textColor = LocalLMTheme.current.colors.white.copy(0.4f))
        }
    }
}
