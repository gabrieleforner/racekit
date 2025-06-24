# 🏎️ RaceKit – F1 24 Telemetry Viewer

**RaceKit** is a real-time telemetry viewer for the official *F1 24* game by Codemasters. Built with **JavaFX** and managed with **Maven**, it offers a responsive dashboard to monitor live racing data — perfect for sim racers, eSports teams, and race engineers.

---

## ⚙️ Features

- **📡 Real-Time UDP Telemetry**
  - Parses Codemasters' F1 24 UDP data format
  - Customizable **IP address** and **port**
  - Supports multiple data formats (e.g. legacy or updated)

- **📊 Modern UI with JavaFX**
  - Live dashboards for:
    - Lap times, deltas, sector splits
    - ERS/battery usage, fuel, tyre wear
    - Car status and session info
  - Built with FXML + dynamic controls

- **🎨 Built-in Themes**
  - Powered by [Atlantafx](https://github.com/mhrimaz/atlantafx)
  - Includes: Primer Light/Dark, Cupertino Light/Dark, Nord Light/Dark
  - Selectable from UI with live switching

- **📁 Lightweight & Portable**
  - Pure JavaFX app, no additional runtime needed
  - Easily packaged with `jlink` / `jpackage` if desired

---

## 🧱 Tech Stack

| Area            | Tech                  |
|------------------|------------------------|
| UI Framework     | JavaFX + FXML          |
| Dependency Mgmt  | Maven                  |
| UDP Networking   | Java NIO               |
| UI Themes        | Atlantafx              |
| Build Tool       | Maven + JavaFX Plugin  |
| Testing          | JUnit 5 (optional)     |

---

## Some screenshots

![Screenshot 2025-06-24 at 18 54 04](https://github.com/user-attachments/assets/84bc9e9c-2faf-4b90-92d2-2c08dd2579c4)
![Screenshot 2025-06-24 at 18 53 19](https://github.com/user-attachments/assets/c062ad19-6cd1-4c39-bb5e-87947c0bb913)


## 🚀 Getting Started

### 1. Clone the project

```bash
git clone https://github.com/your-org/racekit.git
cd racekit
