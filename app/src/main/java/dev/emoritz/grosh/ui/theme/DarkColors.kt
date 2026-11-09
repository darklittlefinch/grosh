package dev.emoritz.grosh.ui.theme

import androidx.compose.ui.graphics.Color

private val DarkCategoryPalette = GroshCategoryPalette(
    turquoise = GroshCategoryColors(
        chartSegment = Color(0xFF58D4D0),
        iconBackground = Color(0xFF034D4B),
        icon = Color(0xFF6DECE8)
    ),
    orange = GroshCategoryColors(
        chartSegment = Color(0xFFFE843D),
        iconBackground = Color(0xFF643318),
        icon = Color(0xFFFEB894)
    ),
    blue = GroshCategoryColors(
        chartSegment = Color(0xFF52A9FE),
        iconBackground = Color(0xFF1D446B),
        icon = Color(0xFF9CCCFE)
    ),
    lavender = GroshCategoryColors(
        chartSegment = Color(0xFFD2BFF8),
        iconBackground = Color(0xFF493766),
        icon = Color(0xFFE1D2FF)
    ),
    skyBlue = GroshCategoryColors(
        chartSegment = Color(0xFF7AD1F7),
        iconBackground = Color(0xFF054960),
        icon = Color(0xFFA3E2FF)
    ),
    green = GroshCategoryColors(
        chartSegment = Color(0xFF5CD07C),
        iconBackground = Color(0xFF1D4E2B),
        icon = Color(0xFF76ED95)
    ),
    pink = GroshCategoryColors(
        chartSegment = Color(0xFFFB83BF),
        iconBackground = Color(0xFF612F48),
        icon = Color(0xFFFFB4D6)
    ),
    purple = GroshCategoryColors(
        chartSegment = Color(0xFFD476E3),
        iconBackground = Color(0xFF56335B),
        icon = Color(0xFFF3A4FF)
    ),
    yellow = GroshCategoryColors(
        chartSegment = Color(0xFFF9C635),
        iconBackground = Color(0xFF533F03),
        icon = Color(0xFFFFD776)
    ),
    indigo = GroshCategoryColors(
        chartSegment = Color(0xFF6887E1),
        iconBackground = Color(0xFF30406D),
        icon = Color(0xFF9EB8FE)
    ),
    raspberry = GroshCategoryColors(
        chartSegment = Color(0xFFF75585),
        iconBackground = Color(0xFF652E3C),
        icon = Color(0xFFFEA3B6)
    ),
    lime = GroshCategoryColors(
        chartSegment = Color(0xFFB7E056),
        iconBackground = Color(0xFF3A4913),
        icon = Color(0xFFC5EF61)
    ),
    gray = GroshCategoryColors(
        chartSegment = Color(0xFFA9B3B4),
        iconBackground = Color(0xFF3C4445),
        icon = Color(0xFFC5D0D1)
    ),
    remainingChartSegment = Color(0xFF5E6270)
)

/**
 * Defines the dark Grosh palette, including financial and category colors.
 */
internal val DarkColors = GroshColors(
    accent = Color(0xFFBC9CFE),
    textOnAccent = Color(0xFF1C1D24),
    accentBackground = Color(0xFF42345D),
    textOnAccentBackground = Color(0xFFDCD0FB),
    accentOnInvertedBackground = Color(0xFF8E3EF3),
    secondaryAccent = Color(0xFFCFC1E0),
    textOnSecondaryAccent = Color(0xFF33283F),
    secondaryAccentBackground = Color(0xFF4B3E57),
    textOnSecondaryAccentBackground = Color(0xFFEAE3F2),
    contrastingAccent = Color(0xFFC1C5DF),
    textOnContrastingAccent = Color(0xFF2D3148),
    contrastingAccentBackground = Color(0xFF444961),
    textOnContrastingAccentBackground = Color(0xFFE2E5F5),
    screenBackground = Color(0xFF1C1D24),
    primaryText = Color(0xFFE6E7EE),
    cardBackground = Color(0xFF262833),
    mutedBackground = Color(0xFF3B3E4E),
    secondaryText = Color(0xFFB9BCCB),
    invertedBackground = Color(0xFFF5F6FA),
    textOnInvertedBackground = Color(0xFF1B1D26),
    error = Color(0xFFFF6B6B),
    textOnError = Color(0xFF3D1014),
    errorBackground = Color(0xFF65272D),
    textOnErrorBackground = Color(0xFFFFDADB),
    border = Color(0xFF8C90A0),
    divider = Color(0xFF444756),
    overlay = Color(0xFF000000),
    brightBackground = Color(0xFF414453),
    listItemBackground = Color(0xFF2F3140),
    elevatedBackground = Color(0xFF373A4A),
    highestElevationBackground = Color(0xFF404355),
    lowElevationBackground = Color(0xFF292B37),
    lowestElevationBackground = Color(0xFF17181F),
    dimmedBackground = Color(0xFF1C1D24),
    fixedAccent = Color(0xFFE7DFFD),
    dimmedFixedAccent = Color(0xFFD2BCF8),
    textOnFixedAccent = Color(0xFF33125A),
    secondaryTextOnFixedAccent = Color(0xFF533088),
    fixedSecondaryAccent = Color(0xFFEAE3F2),
    dimmedFixedSecondaryAccent = Color(0xFFCFC1E0),
    textOnFixedSecondaryAccent = Color(0xFF2D2038),
    secondaryTextOnFixedSecondaryAccent = Color(0xFF45374F),
    fixedContrastingAccent = Color(0xFFE2E5F5),
    dimmedFixedContrastingAccent = Color(0xFFC1C5DF),
    textOnFixedContrastingAccent = Color(0xFF282D42),
    secondaryTextOnFixedContrastingAccent = Color(0xFF3E435A),
    income = Color(0xFF34BC8A),
    expense = Color(0xFFF8994A),
    categories = DarkCategoryPalette
)
