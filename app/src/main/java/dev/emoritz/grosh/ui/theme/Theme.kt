package dev.emoritz.grosh.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import dev.emoritz.grosh.ui.theme.extensions.createMaterialColorScheme

private val LocalGroshColors = staticCompositionLocalOf<GroshColors> {
    error("GroshTheme must provide colors.")
}

/**
 * Provides the current Grosh palette to components without exposing theme selection.
 */
object GroshTheme {

    val colors: GroshColors
        @Composable
        @ReadOnlyComposable
        get() = LocalGroshColors.current
}

/**
 * Applies the same light or dark palette to Grosh and Material components.
 */
@Composable
fun GroshTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    val colorScheme = remember(colors) { colors.createMaterialColorScheme() }

    CompositionLocalProvider(LocalGroshColors provides colors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}