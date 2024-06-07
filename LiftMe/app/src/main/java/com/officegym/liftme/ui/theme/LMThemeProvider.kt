package com.officegym.liftme.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun LMThemeProvider(
    lmTheme: LMTheme,
    content: @Composable () -> Unit
) {
    val theme by rememberUpdatedState(lmTheme)
    CompositionLocalProvider(LocalLMTheme provides theme, content = content)
}

internal val LocalLMTheme = staticCompositionLocalOf {
    // Default value
    LMMainThemeDark
}
