package com.rexample.pilketos.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = DarkBackground,
    surface = DarkContainer,
    onBackground = DarkPrimaryWhite,
    onSurface = DarkPrimaryWhite,
    primary = PrimaryGreen,
    secondary = DarkPrimaryGrey,
    onPrimary = DarkPrimaryWhite,
    onSecondary = DarkPrimaryGrey,
    primaryContainer = DarkContainer,
    onPrimaryContainer = DarkPrimaryWhite,
    secondaryContainer = TextFieldLabelColor,
    onSecondaryContainer = DarkSecondaryGrey,
    error = Error
)

private val LightColorScheme = lightColorScheme(
    background = LightBackground,
    surface = LightPrimaryWhite,
    onBackground = LightPrimaryBlack,
    onSurface = LightPrimaryBlack,
    primary = PrimaryGreen,
    secondary = LightPrimaryGrey,
    onPrimary = LightPrimaryWhite,
    onSecondary = LightPrimaryGrey,
    primaryContainer = LightPrimaryWhite,
    onPrimaryContainer = LightPrimaryBlack,
    secondaryContainer = TextFieldLabelColor,
    onSecondaryContainer = LightSecondaryGrey,
    error = Error
)

@Composable
fun PILKETOSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}