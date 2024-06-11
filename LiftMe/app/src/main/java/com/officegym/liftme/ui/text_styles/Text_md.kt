package com.officegym.liftme.ui.text_styles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.officegym.liftme.R
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun Text_md(
    text: String,
    textColor: Color = LocalLMTheme.current.colors.textPrimary,
    lineHeight: TextUnit = 24.sp
) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = lineHeight,
        color = textColor,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(400),
    )
}
