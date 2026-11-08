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
