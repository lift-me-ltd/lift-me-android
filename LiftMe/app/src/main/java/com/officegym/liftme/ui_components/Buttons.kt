package com.officegym.liftme.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.ButtonsSpacing
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun ButtonWithArrow(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(LocalLMTheme.current.colors.white)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = ButtonsSpacing.BUTTON_VERTICAL_SPACING),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text_md(text = text, textColor = LocalLMTheme.current.colors.black)
            Spacer(modifier = Modifier.height(Spacings.SPACING_XS))
            Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = "arrow")
        }
    }
}

@Composable
fun ButtonWithShadow(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    background: Color = Color.White,
    borderColor: Color = LocalLMTheme.current.colors.strokePrimary,
    textColor: Color = Color.White,
    arrowColor: Color? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .shadow(2.dp, shape = RectangleShape, ambientColor = Color.Black.copy(alpha = 0.05f))
            .background(background)
            .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = ButtonsSpacing.BUTTON_VERTICAL_SPACING),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text_md(text = text, textColor = textColor)
            Spacer(modifier = Modifier.height(Spacings.SPACING_XS))
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "arrow",
                colorFilter = arrowColor?.let { ColorFilter.tint(color = it) },
            )
        }
    }
}
