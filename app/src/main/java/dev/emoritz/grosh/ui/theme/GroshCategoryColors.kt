package dev.emoritz.grosh.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Groups chart and legend color with opaque category icon and background colors.
 */
@Immutable
data class GroshCategoryColors(
    val chartSegment: Color,
    val iconBackground: Color,
    val icon: Color
)
