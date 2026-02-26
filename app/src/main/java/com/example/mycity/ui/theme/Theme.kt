package com.example.mycity.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF6C63FF),
    secondary = androidx.compose.ui.graphics.Color(0xFF03DAC5),
    background = androidx.compose.ui.graphics.Color(0xFFF5F5F5)
)

private val DarkColors = darkColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF9A94FF),
    secondary = androidx.compose.ui.graphics.Color(0xFF03DAC5),
    background = androidx.compose.ui.graphics.Color(0xFF121212)
)

@Composable
fun MyCityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}