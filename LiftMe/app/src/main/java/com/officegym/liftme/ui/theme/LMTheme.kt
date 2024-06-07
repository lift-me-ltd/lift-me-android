package com.officegym.liftme.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Stable
class LMTheme(
    colors: Colors
) {
    var colors by mutableStateOf(colors)
        private set

    fun update(other: LMTheme) {
        colors = other.colors
    }
}
