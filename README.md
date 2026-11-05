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

## Development conventions

See [AGENTS.md](AGENTS.md) for project requirements and the branch workflow. Write comments, commit messages, and Pull Request text in English. Local IDE settings in `/.idea/` are ignored by Git.
