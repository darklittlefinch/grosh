package dev.emoritz.grosh.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.emoritz.grosh.R

/**
 * Provides the three bundled Manrope weights used by the design system offline.
 * Source: https://github.com/googlefonts/manrope/tree/468c0dbe38efa331b80bfe9448256abe27be44c3.
 * The SIL OFL 1.1 license is bundled in res/raw/manrope_license.txt.
 */
internal val ManropeFontFamily = FontFamily(
    Font(resId = R.font.manrope_medium, weight = FontWeight.Medium),
    Font(resId = R.font.manrope_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.manrope_bold, weight = FontWeight.Bold)
)
