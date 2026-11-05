package dev.emoritz.grosh.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.emoritz.grosh.ui.compose.MainComponent
import dev.emoritz.grosh.ui.theme.GroshTheme

/**
 * Main activity that hosts the Compose UI.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroshTheme {
                MainComponent()
            }
        }
    }
}
