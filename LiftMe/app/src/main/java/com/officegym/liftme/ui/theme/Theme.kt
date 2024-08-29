package com.officegym.liftme.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val LMDarkImpl = Colors(
    background = BackgroundMainDark,
    backgroundSecondary = BackgroundSecondary,
    backgroundBlur = BackgroundRadial,
    textSecondary = TextSecondary,
    textPrimary = TextPrimary,
    textTertiary = TextTertiary,
    contentPrimary = ContentPrimary,
    successPrimary = SuccessPrimary,
    backgroundTertiary = BackgroundTertiary,
    transparent = Transparent,
    black = Black,
    foregroundPrimary = White,
    white = White,
)

private val LMLightImpl = Colors(
    background = BackgroundMainLight,
    backgroundSecondary = BackgroundSecondary,
    backgroundBlur = BackgroundRadial,
    textSecondary = TextSecondary,
    textPrimary = TextPrimary,
    textTertiary = TextTertiary,
    contentPrimary = ContentPrimary,
    successPrimary = SuccessPrimary,
    backgroundTertiary = BackgroundTertiary,
    transparent = Transparent,
    black = Black,
    foregroundPrimary = White,
    white = White,
)

val LMMainThemeLight = LMTheme(
    colors = LMLightImpl
)

val LMMainThemeDark = LMTheme (
    colors = LMDarkImpl
)

private val LMDarkMaterialColors = darkColorScheme(
    background = LMDarkImpl.foregroundPrimary,
    secondary = LMDarkImpl.foregroundPrimary,
    tertiary = LMDarkImpl.foregroundPrimary,
    onBackground = LMDarkImpl.foregroundPrimary,
    onSecondary = LMDarkImpl.foregroundPrimary,
    onPrimaryContainer = LMDarkImpl.foregroundPrimary,
    surface = LMDarkImpl.foregroundPrimary,
)

private val LMLightMaterialColors = lightColorScheme(
    primary = LMLightImpl.foregroundPrimary,
    secondary = LMLightImpl.foregroundPrimary,
    tertiary = LMLightImpl.foregroundPrimary,
    background = LMLightImpl.foregroundPrimary,
    onBackground = LMLightImpl.foregroundPrimary,
    onSecondary = LMLightImpl.foregroundPrimary,
    onPrimaryContainer = LMLightImpl.foregroundPrimary,
    surface = LMLightImpl.foregroundPrimary
)

@Composable
fun LiftMeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = if (darkTheme) LMMainThemeDark else LMMainThemeLight

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = if (darkTheme) BackgroundMainDark.toArgb() else BackgroundMainLight.toArgb()
            window.navigationBarColor = BackgroundSecondary.toArgb()
        }
    }
    LMThemeProvider(lmTheme = theme) {
        MaterialTheme(
            colorScheme = if (darkTheme) LMDarkMaterialColors else LMLightMaterialColors,
            typography = Typography,
            content = content
        )
    }
}
