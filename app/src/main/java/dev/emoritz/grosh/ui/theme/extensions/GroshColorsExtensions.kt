package dev.emoritz.grosh.ui.theme.extensions

import androidx.compose.material3.ColorScheme
import dev.emoritz.grosh.ui.theme.GroshColors

/**
 * Maps Grosh color roles to Material components without introducing another palette.
 */
internal fun GroshColors.createMaterialColorScheme(): ColorScheme = ColorScheme(
    primary = accent,
    onPrimary = textOnAccent,
    primaryContainer = accentBackground,
    onPrimaryContainer = textOnAccentBackground,
    inversePrimary = accentOnInvertedBackground,
    secondary = secondaryAccent,
    onSecondary = textOnSecondaryAccent,
    secondaryContainer = secondaryAccentBackground,
    onSecondaryContainer = textOnSecondaryAccentBackground,
    tertiary = contrastingAccent,
    onTertiary = textOnContrastingAccent,
    tertiaryContainer = contrastingAccentBackground,
    onTertiaryContainer = textOnContrastingAccentBackground,
    background = screenBackground,
    onBackground = primaryText,
    surface = cardBackground,
    onSurface = primaryText,
    surfaceVariant = mutedBackground,
    onSurfaceVariant = secondaryText,
    surfaceTint = accent,
    inverseSurface = invertedBackground,
    inverseOnSurface = textOnInvertedBackground,
    error = error,
    onError = textOnError,
    errorContainer = errorBackground,
    onErrorContainer = textOnErrorBackground,
    outline = border,
    outlineVariant = divider,
    scrim = overlay,
    surfaceBright = brightBackground,
    surfaceContainer = listItemBackground,
    surfaceContainerHigh = elevatedBackground,
    surfaceContainerHighest = highestElevationBackground,
    surfaceContainerLow = lowElevationBackground,
    surfaceContainerLowest = lowestElevationBackground,
    surfaceDim = dimmedBackground,
    primaryFixed = fixedAccent,
    primaryFixedDim = dimmedFixedAccent,
    onPrimaryFixed = textOnFixedAccent,
    onPrimaryFixedVariant = secondaryTextOnFixedAccent,
    secondaryFixed = fixedSecondaryAccent,
    secondaryFixedDim = dimmedFixedSecondaryAccent,
    onSecondaryFixed = textOnFixedSecondaryAccent,
    onSecondaryFixedVariant = secondaryTextOnFixedSecondaryAccent,
    tertiaryFixed = fixedContrastingAccent,
    tertiaryFixedDim = dimmedFixedContrastingAccent,
    onTertiaryFixed = textOnFixedContrastingAccent,
    onTertiaryFixedVariant = secondaryTextOnFixedContrastingAccent
)
