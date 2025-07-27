package com.officegym.liftme.ui_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.officegym.liftme.R
import com.officegym.liftme.ui.constants.Spacings
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.text_styles.Text_sm
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun AuthTextFieldUi(
    hint: String? = null,
    placeholder: String?,
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier? = null,
    @DrawableRes icon: Int? = null,
    isPassword: Boolean = false,
    isEnabled: Boolean = false,
) {
    Column {
        Text_sm(text = hint ?: "")
        Spacer(modifier = Modifier.height(Spacings.SPACING_MD))
        PrimaryTextFieldUi(placeholder, text, onTextChanged, modifier, icon, isPassword)
    }
}

@Composable
fun PrimaryTextFieldUi(
    placeholder: String?,
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier? = null,
    @DrawableRes icon: Int? = null,
    isPassword: Boolean = false,
    isEnabled: Boolean = false,
) {
    val currentModifier =
        modifier ?: Modifier
            .fillMaxWidth()
            .border(1.dp, LocalLMTheme.current.colors.strokePrimary, RoundedCornerShape(12.dp))
    TextField(
        modifier = currentModifier,
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            if (placeholder != null) {
                Text_md(text = placeholder, textColor = LocalLMTheme.current.colors.white.copy(0.4f))
            }
        },
        leadingIcon = {
            icon?.let { Icon(painter = painterResource(id = it), contentDescription = "textField") }
        },
        singleLine = true,
        colors = textFieldsColours(),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
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

@Composable
fun VerificationCodeField(size: Dp) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, LocalLMTheme.current.colors.strokePrimary, RoundedCornerShape(12.dp))
            .background(LocalLMTheme.current.colors.fillPrimary)
    ) {
        // text?
    }
}



@Composable
fun VerificationCodeUI(width: Dp) {
    Column {
        Text_sm(text = stringResource(id = R.string.confirmation_code))
        Spacer(modifier = Modifier.height(Spacings.SPACING_MD))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            VerificationCodeField(width)
            Spacer(modifier = Modifier.width(Spacings.SPACING_MD))
            VerificationCodeField(width)
            Spacer(modifier = Modifier.width(Spacings.SPACING_MD))
            VerificationCodeField(width)
            Spacer(modifier = Modifier.width(Spacings.SPACING_MD))
            VerificationCodeField(width)
            Spacer(modifier = Modifier.width(Spacings.SPACING_MD))
            VerificationCodeField(width)
            Spacer(modifier = Modifier.width(Spacings.SPACING_MD))
            VerificationCodeField(width)
        }
    }
}
