# Grosh

An Android financial assistant for tracking expenses and income.

The general working rules (naming, architecture, code style, and reviews) are defined in `~/.codex/AGENTS.md` and also apply here. This file contains only Grosh-specific rules.

## Sources

* Design specification: https://docs.google.com/document/d/1pfIh13aJ7aAUyMlOadkU7aSQ0wZXgjSDP7kB6a9mf6I/edit?tab=t.0 — the source of design requirements. Consult it when working on the UI.
* Product specification (the "Financial App" Google Doc): https://docs.google.com/document/d/1HjQkTRCfih3-kC6vuoiANWVpLxaiJEtI4QQhOwESfGE/edit — the source of truth for business logic, screens, and terminology. Consult it before implementing a task.
* Tasks: YouTrack, project `GROSH` (https://emoritz.youtrack.cloud). Milestones (issue type `Веха`, meaning "Milestone") group tasks by screen.
* Repository: https://github.com/darklittlefinch/grosh. The main branch is `main`.

## Project structure

* Use a single Gradle module, `app`.
* Organize code under `dev.emoritz.grosh` into the `application`, `data`, `di`, `domain`, and `ui` packages.
* Keep activities in `ui.activities`, Compose components in `ui.compose`, and the theme in `ui.theme`.
* Add packages to Git when they contain source files. Do not add placeholder files solely to track empty directories.

## Branch workflow

Branches use two prefixes: `version/` and `task/`.

### version/

* App release branches. The name is the version number, for example `version/1.0.0`. Each version corresponds to a YouTrack board (sprint).
* Create the branch from `main`.
* Once the version is complete, merge it into `main`. **Do not delete the version branch**, either locally or in the remote repository.

### task/

* Task branches. Name: `task/<issue_number>_<short_description_in_english>` — omit the project prefix from the issue number and use snake_case for the description. Example: GROSH-1 "Project foundation" → `task/1_project_foundation`.
* Create the branch:
    * from the parent task's branch if the task has a parent;
    * from the version branch if there is no parent.
* Once the task is complete, merge it into the branch it was created from, then delete the task branch from the remote repository. **Do not delete the task branch locally.**

### Merging branches

* Merge all branches (both `task/` and `version/`) through GitHub Pull Requests only. Do not use a local `git merge`.
* Delete remote task branches with `git push origin --delete <branch>`. Do not use `gh pr merge --delete-branch`: it also deletes the local branch.

### Example

Version 1.0.0, epic GROSH-1 with subtasks GROSH-9 through GROSH-15:

1. Create `version/1.0.0` from `main`.
2. Create `task/1_project_foundation` from `version/1.0.0`.
3. Create each subtask branch from `task/1_project_foundation`, for example `task/12_base_ui_components` for GROSH-12.
4. Merge each completed subtask into `task/1_project_foundation` through a PR, then delete its remote branch.
5. Once all subtasks are complete, merge `task/1_project_foundation` into `version/1.0.0` through a PR, then delete its remote branch.
6. Once all tasks for the version are complete, merge `version/1.0.0` into `main` through a PR and retain the version branch.

## Language

* Write all source code and configuration comments, including KDoc/Javadoc, commit messages, Pull Request titles and descriptions, and other development-facing texts in English.
* This project rule takes precedence over the global requirement to write documentation comments in Russian.

## Commits and Pull Requests

* Write commit messages, PR titles, and PR descriptions in English only.
* Do not include AI attribution in commits or PRs: no attribution to Claude Code, Codex, or other AI tools, such as `Co-Authored-By: Claude ...`, `🤖 Generated with Claude Code`, or similar lines.

## Dependency versions

* When adding or updating libraries and frameworks, use the latest stable release.
* Do not use prerelease versions, including alpha, beta, release candidate (RC), or snapshot builds.

## Technology stack

* Kotlin, minSdk 26 (Android 8.0).
* MVVM + Clean Architecture.
* UI: Jetpack Compose. Portrait orientation only.
* Themes: light and dark.
* Local database: Room.
* DI: Koin.
* Tooltips: Balloon.
* Feature flags and settings: Firebase Remote Config with default configuration bundled in the app.
* Remote database and authentication: Firebase — **not part of the MVP**.
* Network requests: Retrofit + Gson — **not part of the MVP**.

Base package: `dev.emoritz.grosh`.

## Current stage: MVP

* Local database only, without a remote Firebase database or synchronization. Authorization uses Android Auto Backup.
* Firebase Remote Config is included in the MVP.
* There is one account for now, but design models and logic to support multiple accounts.
* Operations: expense, income, and account budget adjustment. Do not implement transfers between accounts.
* Monthly statistics only, without period selection.
* No biometrics, savings goals, limits, scheduled payments, family accounts, or receipt scanning.

MVP screens: onboarding (budget and password), password setup, password entry on startup, home with a pie chart, statistics, history, profile, and operation creation/editing.

## Business rules that are easy to miss

* Transfers and account budget adjustments are excluded from income/expense statistics but appear in history.
* Deleted operations are soft-deleted rather than physically removed from the database, in preparation for synchronization. Deleting an operation reverses its effect on the account budget.
* Store a modification timestamp for every mutable entity, in preparation for conflict resolution during synchronization.
* Screens displaying operations (home, statistics, and history) have loading, success, error, and empty states.
* Texts, lists (currencies and initial categories), display limits, and animation durations marked as configurable in the specification must come from Remote Config. Each must have a default value in the configuration bundled with the app: the app must work offline.
