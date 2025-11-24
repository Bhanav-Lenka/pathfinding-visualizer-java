# Pathfinding Visualizer Using Java

A fully interactive Java-based Pathfinding Visualizer that demonstrates how BFS, DFS, Dijkstra, and A* algorithms find paths on a 2D grid.  
Users can place walls, run algorithms, visualize paths, and compare how each algorithm behaves.

---

## Project Overview

This project is a graphical tool built using **Java Swing** that simulates the working of multiple pathfinding algorithms.  
It helps students and developers understand how graph traversal works in real time.

The system includes:
- A 2D grid where obstacles can be drawn
- A control panel with algorithm buttons
- Visual display of the computed shortest path
- Dynamic statistics showing path length and status

This project is especially useful for learning **DSA, AI, pathfinding in games, and graph algorithms**.

---

## Features

### Interactive Grid
- Click and drag to draw walls/obstacles  
- Real-time cell coloring  
- Start node (green) and End node (red)

### Algorithm Visualization
Implements **four major algorithms**:
- 🟦 **BFS** – shortest path in unweighted grids  
- 🟩 **DFS** – deep exploration of nodes  
- 🟧 **Dijkstra** – shortest path using priority queue  
- ⭐ **A\*** – optimal pathfinding using heuristics  

### Statistics Panel
Shows:
- Selected algorithm  
- Path length  
- Status (Found / Not Found)

### Reset Option
- Clears the grid
- Restores start & end nodes

---

## Technologies & Tools Used

| Technology | Purpose |
|-----------|----------|
| **Java (JDK 8+)** | Main programming language |
| **Java Swing** | GUI framework for drawing grid & components |
| **AWT** | Event handling for mouse interaction |
| **Queue / Stack** | BFS & DFS |
| **PriorityQueue** | Dijkstra & A* |
| **2D Array Grid** | Environment representation |

---

##  Steps to Install & Run the Project

### **1️ Install Java**
Make sure you have **Java JDK 8 or above** installed.  
Check version:
```bash
java -version
