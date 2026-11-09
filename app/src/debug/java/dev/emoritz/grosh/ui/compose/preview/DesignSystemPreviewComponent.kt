package dev.emoritz.grosh.ui.compose.preview

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.emoritz.grosh.ui.theme.GroshCategoryColors
import dev.emoritz.grosh.ui.theme.GroshTheme
import dev.emoritz.grosh.ui.theme.extensions.rowAmount

@Preview(name = "Colors - Light", uiMode = Configuration.UI_MODE_NIGHT_NO, widthDp = 360)
@Preview(name = "Colors - Dark", uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 360)
@Composable
private fun ColorsPreviewComponent() {
    GroshTheme {
        ColorPaletteComponent()
    }
}

@Preview(name = "Categories - Light", uiMode = Configuration.UI_MODE_NIGHT_NO, widthDp = 360)
@Preview(name = "Categories - Dark", uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 360)
@Composable
private fun CategoriesPreviewComponent() {
    GroshTheme {
        CategoryPaletteComponent()
    }
}

@Preview(name = "Typography - Light", uiMode = Configuration.UI_MODE_NIGHT_NO, widthDp = 360)
@Preview(name = "Typography - Dark", uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 360)
@Preview(
    name = "Typography - Light, font scale 1.3",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    widthDp = 360,
    fontScale = 1.3f
)
@Preview(
    name = "Typography - Dark, font scale 1.3",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 360,
    fontScale = 1.3f
)
@Composable
private fun TypographyPreviewComponent() {
    GroshTheme {
        TypographySamplesComponent()
    }
}

@Composable
private fun ColorPaletteComponent() {
    val colors = GroshTheme.colors
    val samples = remember(colors) {
        listOf(
            "accent" to colors.accent,
            "textOnAccent" to colors.textOnAccent,
            "accentBackground" to colors.accentBackground,
            "textOnAccentBackground" to colors.textOnAccentBackground,
            "secondaryAccent" to colors.secondaryAccent,
            "contrastingAccent" to colors.contrastingAccent,
            "screenBackground" to colors.screenBackground,
            "cardBackground" to colors.cardBackground,
            "listItemBackground" to colors.listItemBackground,
            "primaryText" to colors.primaryText,
            "secondaryText" to colors.secondaryText,
            "border" to colors.border,
            "divider" to colors.divider,
            "overlay" to colors.overlay,
            "error" to colors.error,
            "textOnError" to colors.textOnError,
            "errorBackground" to colors.errorBackground,
            "textOnErrorBackground" to colors.textOnErrorBackground,
            "income" to colors.income,
            "expense" to colors.expense
        )
    }

    PreviewSectionComponent(title = "Core colors") {
        samples.forEach { (name, color) ->
            ColorSampleComponent(name = name, color = color)
        }
    }
}

@Composable
private fun CategoryPaletteComponent() {
    val colors = GroshTheme.colors
    val categories = colors.categories
    val typography = MaterialTheme.typography
    val samples = remember(categories) {
        listOf(
            "turquoise" to categories.turquoise,
            "orange" to categories.orange,
            "blue" to categories.blue,
            "lavender" to categories.lavender,
            "skyBlue" to categories.skyBlue,
            "green" to categories.green,
            "pink" to categories.pink,
            "purple" to categories.purple,
            "yellow" to categories.yellow,
            "indigo" to categories.indigo,
            "raspberry" to categories.raspberry,
            "lime" to categories.lime,
            "gray (Other)" to categories.gray
        )
    }

    PreviewSectionComponent(title = "Category colors") {
        Text(
            text = "Chart segment and category icon colors",
            color = colors.secondaryText,
            style = typography.bodyMedium
        )
        samples.forEach { (name, categoryColors) ->
            CategorySampleComponent(name = name, colors = categoryColors)
        }
        ColorSampleComponent(
            name = "remainingChartSegment",
            color = categories.remainingChartSegment
        )
    }
}

@Composable
private fun TypographySamplesComponent() {
    val colors = GroshTheme.colors
    val typography = MaterialTheme.typography
    val samples = remember(typography) {
        listOf(
            Triple("displaySmall - Budget", "12 500,50 ₽", typography.displaySmall),
            Triple("headlineLarge - Amount input", "12 500,50 ₽", typography.headlineLarge),
            Triple("headlineMedium - Large title", "Monthly overview", typography.headlineMedium),
            Triple("headlineSmall - Chart total", "12 500,50 ₽", typography.headlineSmall),
            Triple("titleLarge - Screen title", "History", typography.titleLarge),
            Triple("titleMedium - Section title", "Categories", typography.titleMedium),
            Triple("bodyLarge - Row text", "Groceries", typography.bodyLarge),
            Triple("bodyMedium - Secondary text", "Today, 12:30", typography.bodyMedium),
            Triple("labelLarge - Button", "Add operation", typography.labelLarge),
            Triple("labelMedium - Label", "Category", typography.labelMedium),
            Triple("rowAmount - Amount in row", "12 345 678,90 ₽", typography.rowAmount)
        )
    }

    PreviewSectionComponent(title = "Manrope typography") {
        samples.forEach { (name, text, style) ->
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(text = name, color = colors.secondaryText, style = typography.labelMedium)
                Text(text = text, style = style, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
        Text(text = "Income, expense and amount without currency", style = typography.titleMedium)
        Text(text = "+12 345 678,90 ₽", color = colors.income, style = typography.rowAmount)
        Text(text = "−12 345 678,90 ₽", color = colors.expense, style = typography.rowAmount)
        Text(text = "12 345 678,90", style = typography.rowAmount)
    }
}

@Composable
private fun ColorSampleComponent(name: String, color: Color, modifier: Modifier = Modifier) {
    val colors = GroshTheme.colors
    val typography = MaterialTheme.typography

    Surface(modifier = modifier.fillMaxWidth(), color = colors.cardBackground) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color)
                    .border(width = 1.dp, color = colors.border)
            )
            Text(text = name, color = colors.primaryText, style = typography.bodyMedium)
        }
    }
}

@Composable
private fun CategorySampleComponent(
    name: String,
    colors: GroshCategoryColors,
    modifier: Modifier = Modifier
) {
    val themeColors = GroshTheme.colors
    val typography = MaterialTheme.typography

    Surface(modifier = modifier.fillMaxWidth(), color = themeColors.cardBackground) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                modifier = Modifier.weight(1f),
                color = themeColors.primaryText,
                style = typography.bodyMedium
            )
            Box(modifier = Modifier.size(24.dp).background(colors.chartSegment, CircleShape))
            Box(
                modifier = Modifier.size(32.dp).background(colors.iconBackground, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "G", color = colors.icon, style = typography.bodyLarge)
            }
        }
    }
}

@Composable
private fun PreviewSectionComponent(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val colors = GroshTheme.colors
    val typography = MaterialTheme.typography

    Surface(
        modifier = modifier.fillMaxWidth(),
        color = colors.screenBackground,
        contentColor = colors.primaryText
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = title, style = typography.titleLarge)
            content()
        }
    }
}
