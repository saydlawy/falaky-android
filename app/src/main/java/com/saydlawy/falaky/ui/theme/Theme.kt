package com.saydlawy.falaky.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme

val FalakyRed = Color(0xFFE50914)
val FalakyBackground = Color(0xFF0B0B0B)
val FalakySurface = Color(0xFF181818)

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FalakyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = FalakyRed,
            onPrimary = Color.White,
            background = FalakyBackground,
            surface = FalakySurface,
            onSurface = Color.White,
            onBackground = Color.White,
        ),
        content = content,
    )
}
