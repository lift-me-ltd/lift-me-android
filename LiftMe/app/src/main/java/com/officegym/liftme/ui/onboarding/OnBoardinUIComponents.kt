package com.officegym.liftme.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.RoundedCornerConstants
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Display_md
import com.officegym.liftme.ui.text_styles.Text_md

@Composable
fun OnBoardingTitleDescription(title: String, description: String, color: Color) {
    Column {
        Display_md(title, textColor = color)
        Spacer(Modifier.height(Spacings.SPACING_MD))
        Text_md(description, textColor = color)
    }
}

@Composable
fun ArrowBox(isLeft: Boolean = true, onClick: () -> Unit) {
    Box(
        Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(RoundedCornerConstants.ROUNDED_CORNER_2))
            .background(Color.Black)
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(RoundedCornerConstants.ROUNDED_CORNER_2))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.chevron_right),
            contentDescription = null,
            Modifier.rotate(if (isLeft) 180f else 0f)
        )
    }
}
