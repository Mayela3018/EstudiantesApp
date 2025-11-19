package com.ticona.estudiantesapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = PastelPurpleText,
    secondary = PastelCeleste,
    background = PastelPink,
    surface = PastelCard,
    onPrimary = Color.White,
    onBackground = PastelPurpleText,
    onSurface = PastelPurpleText
)

@Composable
fun EstudiantesTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
