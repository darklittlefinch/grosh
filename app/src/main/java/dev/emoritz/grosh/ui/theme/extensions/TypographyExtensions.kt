package dev.emoritz.grosh.ui.theme.extensions

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Displays amounts in history, statistics and chart legend rows with tabular digits.
 */
val Typography.rowAmount: TextStyle
    get() = bodyLarge.copy(
        fontWeight = FontWeight.Bold,
        fontFeatureSettings = "tnum"
    )
