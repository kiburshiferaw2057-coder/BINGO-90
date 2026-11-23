# BINGO ET — Native Android (Java + Kotlin) Repository

Ready-to-upload repository for **BINGO ET** (`et.bingo.app`) built with **Kotlin** (`MainActivity.kt`), **Java** (`BingoJavaBridge.java`), and the full BINGO ET game engine.

## Repository Structure
- `.github/workflows/main.yml` — Automated GitHub Actions build producing both `app-debug.apk` and Play Store `app-release.aab`.
- `android/app/src/main/kotlin/et/bingo/app/MainActivity.kt` — Kotlin main entry activity.
- `android/app/src/main/java/et/bingo/app/BingoJavaBridge.java` — Java native bridge (`@JavascriptInterface`) for Birr (`ETB`) formatting and `1–600` card checks.
- `android/app/build.gradle` — Configured for Android SDK 34, Java 17, and Kotlin 1.9.22.
- `index.html`, `styles.css`, `app.js`, `manifest.json`, `sw.js` — Full BINGO ET interface (`1–600` selector, `2`-minute round timer, live `75`-ball board, Birr wallet).
