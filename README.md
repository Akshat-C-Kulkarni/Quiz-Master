<div align="center">

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 900 200" width="900" height="200">
  <defs>
    <linearGradient id="bgq" x1="0%" y1="0%" x2="100%" y2="100%">
      <stop offset="0%" style="stop-color:#1a0533"/>
      <stop offset="100%" style="stop-color:#0f0f1a"/>
    </linearGradient>
    <linearGradient id="accq" x1="0%" y1="0%" x2="100%" y2="0%">
      <stop offset="0%" style="stop-color:#a855f7"/>
      <stop offset="100%" style="stop-color:#6366f1"/>
    </linearGradient>
  </defs>
  <rect width="900" height="200" fill="url(#bgq)" rx="12"/>
  <!-- Grid subtle -->
  <line x1="0" y1="66" x2="900" y2="66" stroke="#ffffff06" stroke-width="1"/>
  <line x1="0" y1="133" x2="900" y2="133" stroke="#ffffff06" stroke-width="1"/>
  <!-- Pie chart decoration -->
  <circle cx="800" cy="100" r="60" fill="none" stroke="#a855f720" stroke-width="1"/>
  <!-- Pie slices -->
  <path d="M800,100 L800,45 A55,55 0 0,1 847,127 Z" fill="#a855f7" opacity="0.7"/>
  <path d="M800,100 L847,127 A55,55 0 0,1 756,148 Z" fill="#6366f1" opacity="0.7"/>
  <path d="M800,100 L756,148 A55,55 0 0,1 745,72 Z" fill="#ec4899" opacity="0.6"/>
  <path d="M800,100 L745,72 A55,55 0 0,1 800,45 Z" fill="#8b5cf6" opacity="0.5"/>
  <circle cx="800" cy="100" r="22" fill="#0f0f1a"/>
  <text x="800" y="105" font-family="monospace" font-size="11" fill="#a855f7" text-anchor="middle">92%</text>
  <!-- Quiz option boxes -->
  <rect x="650" y="35" width="110" height="22" rx="4" fill="#a855f720" stroke="#a855f740" stroke-width="1"/>
  <text x="660" y="50" font-family="monospace" font-size="9" fill="#a855f7">◉  Option A</text>
  <rect x="650" y="63" width="110" height="22" rx="4" fill="#6366f120" stroke="#6366f140" stroke-width="1"/>
  <text x="660" y="78" font-family="monospace" font-size="9" fill="#6366f1">○  Option B</text>
  <rect x="650" y="91" width="110" height="22" rx="4" fill="#22c55e20" stroke="#22c55e60" stroke-width="1.5"/>
  <text x="660" y="106" font-family="monospace" font-size="9" fill="#22c55e">✓  Option C ←</text>
  <rect x="650" y="119" width="110" height="22" rx="4" fill="#a855f710" stroke="#a855f730" stroke-width="1"/>
  <text x="660" y="134" font-family="monospace" font-size="9" fill="#9ca3af">○  Option D</text>
  <!-- Title -->
  <text x="50" y="88" font-family="Georgia, serif" font-size="50" font-weight="bold" fill="url(#accq)">QuizMaster</text>
  <text x="50" y="130" font-family="monospace" font-size="13" fill="#7c3aed">Android · Kotlin · MVVM · MPAndroidChart</text>
  <text x="50" y="162" font-family="monospace" font-size="11" fill="#4b5563">Interactive quizzes · Real-time scoring · Visual analytics</text>
</svg>

# QuizMaster

> **An engaging Android quiz application — test your knowledge and visualize performance with interactive analytics**

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android%20SDK-35-3DDC84?style=flat-square&logo=android&logoColor=white)](https://developer.android.com)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24%20(Nougat)-orange?style=flat-square)]()
[![Architecture](https://img.shields.io/badge/Architecture-MVVM-6366f1?style=flat-square)]()
[![MPAndroidChart](https://img.shields.io/badge/MPAndroidChart-Charts-a855f7?style=flat-square)](https://github.com/PhilJay/MPAndroidChart)
[![Status](https://img.shields.io/badge/Status-Active-22c55e?style=flat-square)]()

</div>

---

## Overview

**QuizMaster** is a feature-rich Android application that delivers an engaging quiz experience with real-time scoring and deep performance analytics. Built with Kotlin and following MVVM architecture, the app combines clean UI design with meaningful visual feedback — letting users not just take quizzes, but genuinely understand their strengths and improvement areas through interactive pie charts and score breakdowns.

---

## Architecture

```
┌──────────────────────────────────────────────────────────────────┐
│                        QuizMaster — MVVM                         │
│                                                                  │
│  ┌──────────────────────────────────────────────────────────┐    │
│  │                        UI Layer                           │   │
│  │   QuizActivity · ResultActivity · AnalyticsFragment       │   │
│  └───────────────────────────┬──────────────────────────────┘    │
│                              │  observes                         │
│  ┌───────────────────────────▼──────────────────────────────┐    │
│  │                     ViewModel Layer                      │    │
│  │   QuizViewModel · ResultViewModel · AnalyticsViewModel   │    │
│  └───────────────────────────┬──────────────────────────────┘    │
│                              │  requests                         │
│  ┌───────────────────────────▼──────────────────────────────┐    │
│  │                      Data Layer                          │    │
│  │   QuizRepository · ScoreRepository · Local DB (Room)     │    │
│  └──────────────────────────────────────────────────────────┘    │
│                                                                  │
│  External: MPAndroidChart (Pie · Bar · Line charts)              │
└──────────────────────────────────────────────────────────────────┘
```

---

## Key Features

- **Interactive Quizzes** — Multiple-choice questions across diverse topics with smooth navigation
- **Real-time Scoring** — Instant feedback and score calculation after every question and quiz
- **Visual Analytics** — Beautiful interactive Pie Charts via MPAndroidChart for deep performance insights
- **Score History** — Track performance over time to monitor improvement
- **Modern UI** — Clean, responsive Material Design interface optimized for Android
- **MVVM Architecture** — Scalable, testable codebase with clear separation of concerns

---

## Tech Stack

| Category | Tools |
|---|---|
| Language | Kotlin 1.9.0 |
| Platform | Android (Min SDK 24, Target SDK 35) |
| Architecture | MVVM |
| Charts | MPAndroidChart |
| Build System | Gradle (KTS) |
| IDE | Android Studio Ladybug+ |

---

## Getting Started

### Prerequisites

- Android Studio **Ladybug** or newer
- **JDK 17**
- Android device or emulator (API 24+)

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/Akshat-C-Kulkarni/Quiz-Master.git
cd Quiz-Master
```

```
# 2. Open in Android Studio
   File → Open → Select the Quiz-Master folder
```

```
# 3. Sync & Build
   Let Gradle sync dependencies automatically
   Build → Make Project
```

```
# 4. Run
   Connect device or start emulator
   Press ▶ Run
```

---

## Project Structure

```
Quiz-Master/
├── app/
│   ├── src/main/
│   │   ├── java/
│   │   │   ├── ui/            # Activities & Fragments
│   │   │   ├── viewmodel/     # ViewModels
│   │   │   ├── repository/    # Data repositories
│   │   │   ├── model/         # Data classes
│   │   │   └── utils/         # Helpers & extensions
│   │   └── res/
│   │       ├── layout/        # XML layouts
│   │       ├── values/        # Colors, strings, themes
│   │       └── drawable/      # Icons and assets
├── build.gradle.kts
└── README.md
```

---

## Dependencies

```kotlin
// MPAndroidChart - Interactive charts
implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
```

---

## Contributing

Contributions are welcome!

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/AmazingFeature`
3. Commit your changes: `git commit -m 'Add AmazingFeature'`
4. Push to the branch: `git push origin feature/AmazingFeature`
5. Open a Pull Request

---

## Author

**Akshat C. Kulkarni**
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0A66C2?style=flat-square&logo=linkedin)](https://linkedin.com/in/akshatckulkarni)
[![GitHub](https://img.shields.io/badge/GitHub-Profile-181717?style=flat-square&logo=github)](https://github.com/Akshat-C-Kulkarni)

Project Link: [https://github.com/Akshat-C-Kulkarni/Quiz-Master](https://github.com/Akshat-C-Kulkarni/Quiz-Master)

---

<div align="center"><sub>Built with Kotlin · Android SDK · MVVM · MPAndroidChart</sub></div>
