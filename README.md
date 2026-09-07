# BaldFällig

Native Android app for tracking recurring payments (subscriptions, insurance, rent, memberships, etc.) with due-date reminders and cost overviews.

> ⚠️ Project is in an early stage.

## Status

Currently in **Phase 1: Local MVP**

- [ ] Project setup & base architecture (MVVM)
- [ ] Data model & local persistence
- [ ] CRUD for recurring payments
- [ ] Multi-currency handling (manual exchange rate)
- [ ] Local reminders
- [ ] Dashboard / cost overview

## Tech Stack

> Versions verified as current & mutually compatible on 2026-09-07

- **Language:** Kotlin
- **Platform:** Native Android
- **Architecture:** MVVM
- **Persistence:** Room (local, Phase 1) — TODO: confirm once Epic 2 is implemented
- **Min SDK:** 26 (Android 8.0)
- **Target SDK:** 37
- **Kotlin version:** 2.2.10
- **Build system:** Gradle 9.5.0, AGP 9.3.2
- **KSP:** 2.3.11
- **Coroutines:** 1.11.0
- **Lifecycle:** 2.11.0
- **Room:** 3.0.2 — chosen over Room 2.x, which is deprecated
- **Navigation3:** 1.1.7 — chosen over Navigation Compose v2, which is in maintenance mode

> Planned for later phases (not yet relevant): Spring Boot + PostgreSQL backend (Phase 2)

## Getting Started

### Prerequisites

- Android Studio: latest stable version compatible with AGP 9.3 (see [AGP release notes](https://developer.android.com/build/releases/gradle-plugin))
- JDK: 17 (required by AGP 9.3 to run Gradle)

### Setup

```bash
git clone https://github.com/sebasukodo-labs/baldfaellig.git
cd baldfaellig
```

### Start App

1. Open the project in Android Studio.
2. Wait for Gradle to sync and complete the project setup.
3. Select an available emulator or connect an Android device.
4. Run the app using Run ▶.
5. If prompted, accept any required Android SDK or build tool installations.

## Project Structure

The app follows a package-by-layer structure (MVVM), suitable for the current project size.

### Current

```
├── ui/           # Composables / screens
└── navigation/   # NavKeys, NavDisplay setup
```

### Planned for the Future

```
├── data/         # Room entities, DAOs, database
├── viewmodel/    # ViewModels
└── domain/       # Use Cases, Domain Models, Business Logic
```

## Contributing

For commit message conventions, see [CONTRIBUTING.md](./CONTRIBUTING.md).

## License

TODO