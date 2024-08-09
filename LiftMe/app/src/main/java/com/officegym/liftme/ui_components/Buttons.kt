package com.officegym.liftme.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
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
    ) {
        Row {
            Text_md(text = text, textColor = LocalLMTheme.current.colors.black)
        }
    }
}
