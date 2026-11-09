package dev.emoritz.grosh.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines reusable category colors and the separate aggregated chart segment.
 * Custom categories use the twelve chromatic colors; gray is reserved for "Other".
 */
@Immutable
data class GroshCategoryPalette(
    val turquoise: GroshCategoryColors,
    val orange: GroshCategoryColors,
    val blue: GroshCategoryColors,
    val lavender: GroshCategoryColors,
    val skyBlue: GroshCategoryColors,
    val green: GroshCategoryColors,
    val pink: GroshCategoryColors,
    val purple: GroshCategoryColors,
    val yellow: GroshCategoryColors,
    val indigo: GroshCategoryColors,
    val raspberry: GroshCategoryColors,
    val lime: GroshCategoryColors,
    val gray: GroshCategoryColors,
    val remainingChartSegment: Color
)
