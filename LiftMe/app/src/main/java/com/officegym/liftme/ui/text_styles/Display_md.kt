package com.officegym.liftme.ui.text_styles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.officegym.liftme.R

@Composable
fun Display_md(
    text: String,
    fontSize: TextUnit = 36.sp,
    lineHeight: TextUnit = 40.sp,
    fontWeight: FontWeight = FontWeight(800)

) {
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = fontWeight,
        lineHeight = lineHeight
    )
}
