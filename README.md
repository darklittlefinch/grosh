# Grosh

An Android app for tracking personal expenses and income.

## Project structure

Grosh uses a single Gradle module, `app`, with package-level separation for MVVM and Clean Architecture. All application code belongs to the `dev.emoritz.grosh` base package.

| Package | Responsibility |
| --- | --- |
| `application` | Application initialization and lifecycle |
| `data` | Storage, entities, and repositories |
| `di` | Dependency injection configuration |
| `domain` | Models and operation results |
| `ui` | Activities, Compose components, themes, and presentation data |

Packages are added to Git together with their source files. Empty package directories do not require placeholder files.

The current UI entry points are:

* `ui.activities.MainActivity` — enables edge-to-edge rendering and hosts the app theme.
* `ui.compose.MainComponent` — displays the app name in a root `Scaffold` and applies its system window insets. Includes light and dark theme previews.
* `ui.theme` — contains the existing theme, colors, and typography.

## Android configuration

* Minimum Android version: Android 8.0 (API 26).
* Compile and target SDK: API 37.
* Application ID and namespace: `dev.emoritz.grosh`.
* Language and UI: Kotlin and Jetpack Compose with Material 3.
* `MainActivity` requests portrait orientation in the manifest. On large screens, Android can override this request. Apps targeting API 37 cannot opt out of this behavior on Android 17; see the [Android platform documentation](https://developer.android.com/about/versions/17/behavior-changes-17#device-form-factors).

Dependency and project plugin versions are defined in [gradle/libs.versions.toml](gradle/libs.versions.toml). The Gradle Wrapper version and Gradle JVM criteria are defined in [gradle/wrapper/gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties) and [gradle/gradle-daemon-jvm.properties](gradle/gradle-daemon-jvm.properties).

## Design system

Wrap app content in `GroshTheme`. It follows the system light/dark setting by default; pass `darkTheme = false` or `darkTheme = true` to select a theme explicitly. Dynamic wallpaper colors are disabled so the app uses its defined palette.

`LightColors.kt` and `DarkColors.kt` define the palettes. `GroshColors` provides named roles through `GroshTheme.colors`, including `screenBackground`, `cardBackground`, `listItemBackground`, `primaryText`, `secondaryText`, `accent`, `income`, and `expense`.

```kotlin
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import dev.emoritz.grosh.ui.theme.GroshTheme
import dev.emoritz.grosh.ui.theme.extensions.rowAmount

// Inside GroshTheme content:
Text(
    text = "+12 500,50 ₽",
    color = GroshTheme.colors.income,
    style = MaterialTheme.typography.rowAmount
)
```

Material 3 components receive a `ColorScheme` derived from the same palette. Theme selection is handled once in `GroshTheme`; components read colors without checking the active theme. Category colors are available through `GroshTheme.colors.categories`, for example `categories.blue.chartSegment`, `categories.blue.iconBackground`, and `categories.blue.icon`. The twelve chromatic colors are available for custom categories; `gray` is reserved for "Other", and `remainingChartSegment` colors the aggregated "Remaining" chart segment.

Typography uses bundled Manrope Medium (500), SemiBold (600), and Bold (700) fonts and works offline. Use `MaterialTheme.typography` for the approved text roles. Amount styles (`displaySmall`, `headlineLarge`, `headlineSmall`, and the `rowAmount` extension) enable tabular digits with `tnum`. `rowAmount` uses 16/24 sp and Bold; ordinary `bodyLarge` text uses Medium. Styles at 24 sp and above use -1% letter spacing. Additional Material roles reuse the approved scale. The font license is bundled in [manrope_license.txt](app/src/main/res/raw/manrope_license.txt).

Debug-only examples live in [DesignSystemPreviewComponent.kt](app/src/debug/java/dev/emoritz/grosh/ui/compose/preview/DesignSystemPreviewComponent.kt). Open the file in Android Studio's Compose Preview to inspect core colors, all category colors, typography, income/expense amounts, and long amounts with and without a currency symbol. Each example has light and dark variants; typography also has variants at font scale 1.3. These previews use the theme directly and do not require Koin or runtime app navigation.

The theme uses stable Material 3 APIs. `MaterialExpressiveTheme` and `MotionScheme.expressive()` are deferred until available in a stable release, in accordance with the project's dependency policy. The profile theme selector and persistence of the user's choice belong to the profile feature.

## Dependency injection

Koin is initialized once in `GroshApplication.initializeKoin()`, called from `Application.onCreate()`. The application class is registered in the manifest. Compose uses this existing container automatically.

Modules live in `dev.emoritz.grosh.di`:

* `repositoriesModule` holds repositories.
* `modelsModule` holds model implementations bound to their interfaces.
* `viewModelsModule` holds screen ViewModels.
* `apiServiceModule` holds API services.

All four modules are passed directly to `modules(repositoriesModule, modelsModule, viewModelsModule, apiServiceModule)` inside `initializeKoin()`.

The modules are currently empty. Add definitions as features are implemented. Register model implementations against their interfaces and inject those interfaces into ViewModels.

### Compose ViewModels

`koin-androidx-compose` provides `koinViewModel()`. The following snippets illustrate a future `HomeViewModel` extending `androidx.lifecycle.ViewModel`; this class is not part of the current application.

Register the ViewModel in `ViewModelsModule.kt` and its constructor dependencies in the corresponding modules:

```kotlin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::HomeViewModel)
}
```

Retrieve it at the screen entry point:

```kotlin
import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel

/**
 * Hosts the home screen and observes its ViewModel.
 */
@Composable
fun HomeComponent(viewModel: HomeViewModel = koinViewModel()) {
    // Observe screen state and events, then render screen content.
}
```

The ViewModel belongs to the current `ViewModelStoreOwner`, provided by the Activity or navigation destination. Keep reusable UI components independent of DI by passing data and callbacks; this also allows previews without starting Koin.

See the [Koin 4.1 Compose documentation](https://insert-koin.io/docs/4.1/reference/koin-compose/compose/).

## Development conventions

See [AGENTS.md](AGENTS.md) for project requirements and the branch workflow. Write comments, commit messages, and Pull Request text in English. Local IDE settings in `/.idea/` are ignored by Git.
