package com.example.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun AdaptiveLayout(
    content: @Composable () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    if (screenWidth > 600) {
        Row {
            content()
        }
    } else {
        content()
    }
}