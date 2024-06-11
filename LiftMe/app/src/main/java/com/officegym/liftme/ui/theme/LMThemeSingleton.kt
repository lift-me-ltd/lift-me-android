package com.officegym.liftme.ui.theme

import androidx.compose.runtime.Composable

object LMThemeSingleton {
    val lmTheme: LMTheme
        @Composable
        get() = LocalLMTheme.current
}
