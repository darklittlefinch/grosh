package dev.emoritz.grosh.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * Defines the approved Manrope scale for both app themes.
 */
val Typography = createTypography()

private fun createTypography(): Typography {
    val bodyLarge = TextStyle(
        fontFamily = ManropeFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
    val bodyMedium = bodyLarge.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
    val labelLarge = bodyLarge.copy(fontWeight = FontWeight.SemiBold)
    val labelMedium = labelLarge.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
    val titleLarge = labelLarge.copy(
        fontSize = 22.sp,
        lineHeight = 28.sp
    )
    val titleMedium = labelLarge.copy(fontSize = 18.sp)
    val headlineMedium = bodyLarge.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.01).em
    )
    val displaySmall = headlineMedium.copy(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontFeatureSettings = "tnum"
    )
    val headlineLarge = displaySmall.copy(
        fontSize = 32.sp,
        lineHeight = 40.sp
    )
    val headlineSmall = displaySmall.copy(
        fontSize = 24.sp,
        lineHeight = 32.sp
    )

    // Other Material roles reuse the approved scale to avoid extra sizes and default fonts.
    return Typography(
        displayLarge = displaySmall,
        displayMedium = displaySmall,
        displaySmall = displaySmall,
        headlineLarge = headlineLarge,
        headlineMedium = headlineMedium,
        headlineSmall = headlineSmall,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleMedium,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodySmall = bodyMedium,
        labelLarge = labelLarge,
        labelMedium = labelMedium,
        labelSmall = labelMedium
    )
}