package com.officegym.liftme.ui_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.text_styles.Text_sm
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun AuthTextFieldUi(
    hint: String,
    placeholder: String,
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier? = Modifier,
    @DrawableRes icon: Int? = null,
) {
    Column {
        Text_sm(text = hint)
        Spacer(modifier = Modifier.height(Spacings.SPACING_MD))
        PrimaryTextFieldUi(placeholder, text, onTextChanged, modifier, icon)
    }
}

@Composable
fun PrimaryTextFieldUi(
    placeholder: String,
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier? = Modifier,
    @DrawableRes icon: Int? = null,
) {
    val currentModifier = modifier ?: Modifier.fillMaxWidth()
    TextField(
        modifier = currentModifier.border(1.dp, LocalLMTheme.current.colors.strokePrimary, RoundedCornerShape(12.dp)),
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            Text_md(text = placeholder, textColor = LocalLMTheme.current.colors.white.copy(0.4f))
        },
        leadingIcon = {
            icon?.let { Icon(painter = painterResource(id = it), contentDescription = "textField") }
        },
        singleLine = true,
        colors = textFieldsColours()
    )
}

@Composable
fun textFieldsColours(): TextFieldColors {
    return TextFieldColors(
        unfocusedLabelColor = Color.Transparent,
        focusedLabelColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledTextColor = LocalLMTheme.current.colors.textPrimary,
        errorTextColor = LocalLMTheme.current.colors.textPrimary, // error color
        cursorColor = LocalLMTheme.current.colors.contentPrimary, // cursor color
        disabledPrefixColor = Color.Transparent,
        disabledSuffixColor = Color.Transparent,
        disabledLabelColor = Color.Transparent,
        disabledSupportingTextColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        disabledLeadingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        disabledPlaceholderColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        disabledTrailingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        unfocusedTextColor = LocalLMTheme.current.colors.textPrimary,
        focusedTextColor = LocalLMTheme.current.colors.textPrimary,
        focusedIndicatorColor = Color.Transparent,
        focusedSupportingTextColor = Color.Transparent,
        unfocusedSupportingTextColor = Color.Transparent,
        errorLeadingIconColor = Color.Transparent,
        errorPlaceholderColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        unfocusedPrefixColor = Color.Transparent,
        unfocusedSuffixColor = Color.Transparent,
        focusedPrefixColor = Color.Transparent,
        focusedSuffixColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedLeadingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        focusedPlaceholderColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        focusedTrailingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        unfocusedLeadingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        unfocusedPlaceholderColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        unfocusedTrailingIconColor = LocalLMTheme.current.colors.textPrimary.copy(0.4f),
        errorContainerColor = Color.Transparent,
        errorCursorColor = Color.Transparent,
        errorPrefixColor = Color.Transparent,
        errorSuffixColor = Color.Transparent,
        errorLabelColor = Color.Transparent,
        errorSupportingTextColor = Color.Transparent,
        errorTrailingIconColor = Color.Transparent,
        textSelectionColors = TextSelectionColors(Color.Transparent, Color.Transparent)
    )
}
