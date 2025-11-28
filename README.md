![Static Badge](https://img.shields.io/badge/author-javiergs-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/CSC3100/Tool-PlantUML)

This lightweight Java Swing application renders PlantUML diagrams directly inside a GUI window.  
It takes a UML source string, generates a PNG image using PlantUML, and displays it in a scrollable panel—no external tools or file generation required.

<p align="center">
<img width="512" height="412" alt="Screenshot 2025-11-28 at 3 58 08 AM" src="https://github.com/user-attachments/assets/601898d1-7265-4e4a-9116-76ce09b19591" />
</p>

## 🚀 Features
- Display the generated diagram inside a Swing `JPanel`  
- **Scrollable viewer** for large diagrams  

## 📁 Project Structure
This project consists of two files:

- **`Driver.java`** — Application entry point and main window  
- **`DiagramPanel.java`** — Component that renders and displays the PlantUML output  

## 📦 PlantUML Dependency (Maven)

```xml
<dependency>
    <groupId>net.sourceforge.plantuml</groupId>
    <artifactId>plantuml</artifactId>
    <version>1.2023.13</version>
</dependency>
