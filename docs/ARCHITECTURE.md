# Architecture (stage 1)

- Modules: `:app` (Hilt, theme, activity), `:core:model` (pure Kotlin helpers), `:core:database` (Room, schemas exported and committed), `:core:network` (Xtream client interface), `:feature:home` (TV home placeholder).
- Android TV only: leanback launcher, no touchscreen requirement, landscape, Compose for TV.
- minSdk 24, compileSdk 37.2 (required by current Compose), targetSdk 37. JDK 21 builds, Java 17 bytecode.
- Versions live only in `gradle/libs.versions.toml`.
- Release-only: version name/code come from the git tag (`v1.2.3` -> 1.2.3, code 1002003). Release builds are signed in CI only. Without keystore variables the build stays unsigned and is never published.
- Room: no destructive migration fallback; schema changes require a migration and a committed schema file.
- Never in git: keystore, google-services.json, TMDB/Gemini keys, provider URLs.
- Status: written and reviewed but not yet compiled by CI. The first CI run is the first real build.
