package com.officegym.liftme.ui.signup

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.officegym.liftme.R
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun SocialIcon(
    @DrawableRes socialRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .border(1.dp, LocalLMTheme.current.colors.textSecondary, RoundedCornerShape(16.dp))
            .padding(
                vertical = dimensionResource(id = R.dimen.social_icon_vertical_padding)
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
