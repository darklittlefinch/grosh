package dev.emoritz.grosh.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines named UI colors shared by Grosh components and the Material theme.
 * Fixed accents retain their values in both light and dark themes.
 */
@Immutable
data class GroshColors(
    val accent: Color,
    val textOnAccent: Color,
    val accentBackground: Color,
    val textOnAccentBackground: Color,
    val accentOnInvertedBackground: Color,
    val secondaryAccent: Color,
    val textOnSecondaryAccent: Color,
    val secondaryAccentBackground: Color,
    val textOnSecondaryAccentBackground: Color,
    val contrastingAccent: Color,
    val textOnContrastingAccent: Color,
    val contrastingAccentBackground: Color,
    val textOnContrastingAccentBackground: Color,
    val screenBackground: Color,
    val primaryText: Color,
    val cardBackground: Color,
    val mutedBackground: Color,
    val secondaryText: Color,
    val invertedBackground: Color,
    val textOnInvertedBackground: Color,
    val error: Color,
    val textOnError: Color,
    val errorBackground: Color,
    val textOnErrorBackground: Color,
    val border: Color,
    val divider: Color,
    val overlay: Color,
    val brightBackground: Color,
    val listItemBackground: Color,
    val elevatedBackground: Color,
    val highestElevationBackground: Color,
    val lowElevationBackground: Color,
    val lowestElevationBackground: Color,
    val dimmedBackground: Color,
    val fixedAccent: Color,
    val dimmedFixedAccent: Color,
    val textOnFixedAccent: Color,
    val secondaryTextOnFixedAccent: Color,
    val fixedSecondaryAccent: Color,
    val dimmedFixedSecondaryAccent: Color,
    val textOnFixedSecondaryAccent: Color,
    val secondaryTextOnFixedSecondaryAccent: Color,
    val fixedContrastingAccent: Color,
    val dimmedFixedContrastingAccent: Color,
    val textOnFixedContrastingAccent: Color,
    val secondaryTextOnFixedContrastingAccent: Color,
    val income: Color,
    val expense: Color,
    val categories: GroshCategoryPalette
)
