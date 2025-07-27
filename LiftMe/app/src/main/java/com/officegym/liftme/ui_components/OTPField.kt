package com.officegym.liftme.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.officegym.liftme.ui.text_styles.Text_md
import com.officegym.liftme.ui.theme.LocalLMTheme

@Composable
fun OTPField(
    codeLength: Int,
    initialCode: String,
    onTextChanged: (String) -> Unit,
    visualTransformation: VisualTransformation?,
//    isError: Boolean,
    onClick: () -> Unit,
    width: Dp,
) {

    val code = remember(initialCode) {
        mutableStateOf(TextFieldValue(initialCode, TextRange(initialCode.length)))
    }
    val focusRequester = FocusRequester()
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        if (visualTransformation != null) {
            CompositionLocalProvider(
                LocalTextInputService provides null
            ) {
                BasicTextField(
                    value = code.value,
                    onValueChange = { onTextChanged(it.text) },
                    modifier = Modifier
                        .focusRequester(focusRequester = focusRequester)
                        .clickable { onClick() },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    decorationBox = {
                        CodeInputDecoration(
                            code.value.text,
                            codeLength,
                            visualTransformation,
                            size = width,
//                            isError,
//                            code.value.selection.start,
                        )
                    },
                    visualTransformation = visualTransformation
                )
            }
        } else {
            CompositionLocalProvider(
                LocalTextInputService provides null
            ) {
                BasicTextField(
                    value = code.value,
                    onValueChange = { onTextChanged(it.text) },
                    modifier = Modifier.focusRequester(focusRequester = focusRequester),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions {},
                    decorationBox = {
                        CodeInputDecoration(
                            code.value.text,
                            codeLength,
                            null,
                            size = width,
//                            isError,
//                            code.value.selection.start,
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun CodeInputDecoration(
    code: String,
    length: Int,
    visualTransformation: VisualTransformation?,
    size: Dp,
//    isError: Boolean,
//    focusedIndex: Int,
) {
    Box(modifier = Modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (i in 0 until length) {
                val text = if (i < code.length) code[i].toString() else ""
                CodeEntry(
                    text = text,
                    visualTransformation = visualTransformation,
                    size = size,
//                    sError,
//                    i == focusedIndex
                )
            }
        }
    }
}

@Composable
private fun CodeEntry(
    text: String,
    visualTransformation: VisualTransformation?,
    size: Dp,
//    isError: Boolean,
//    isFocused: Boolean = false,
) {
    val transformedText = remember(text, visualTransformation) {
        visualTransformation?.filter(AnnotatedString(text))
    }?.text?.text

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(12.dp))
                .border(1.dp, LocalLMTheme.current.colors.strokePrimary, RoundedCornerShape(12.dp))
                .background(LocalLMTheme.current.colors.fillPrimary),
            contentAlignment = Alignment.Center
        ) {
            Text_md(text = transformedText ?: text.ifEmpty { " " })
        }
    }
}
