# Project Statement – Pathfinding Visualizer (Java)

##  Problem Statement
Understanding pathfinding algorithms like BFS, DFS, Dijkstra, and A* can be difficult because these algorithms run internally without showing how nodes are explored. Students often struggle to visualize how the algorithm moves, how it processes neighbor nodes, and how it constructs the final shortest path.

There is a need for an **interactive visual tool** that demonstrates:
- How each algorithm explores the grid  
- How obstacles affect the search  
- The difference between optimal and non-optimal pathfinding  
- The steps taken before reaching the destination  

The proposed solution is a **Java-based Pathfinding Visualizer** that allows users to build a grid, draw walls, and observe algorithm behavior in real time.


##  Scope of the Project

### **In-Scope**
- Rendering a 2D grid using Java Swing  
- Allowing users to place/remove walls  
- Implementing four major algorithms:
  - BFS  
  - DFS  
  - Dijkstra  
  - A*  
- Displaying the final path visually  
- Showing algorithm statistics (path length, status)  
- Resetting the grid  
- Providing clean, interactive controls  

### **Out Of Scope**
- Animated step-by-step movement (future enhancement)  
- Dynamic weighted terrain  
- Database storage  
- Multi-agent pathfinding  
- Web or mobile version  


##  Target Users

This project is designed for:

### **1. Students learning Data Structures & Algorithms**
To help them understand graph traversal, shortest paths, and heuristics.

### **2. Game Developers**
Who want to learn pathfinding used in:
- NPC navigation  
- Maze solving  
- Open-world movement systems  

### **3. Educators & Trainers**
Who need a visual demonstration tool for classroom teaching.

### **4. Beginners in Java GUI Programming**
To learn event-driven programming with Swing.



##  High-Level Features

### **1. Interactive Grid System**
- Click and drag to draw walls  
- Visual feedback in real time  
- Start (green) and End (red) nodes  

### **2. Algorithm Visualizations**
- **BFS:** Guaranteed shortest path in unweighted grid  
- **DFS:** Deep traversal, shows difference from BFS  
- **Dijkstra:** Uses distance-based priority queue  
- **A\*:** Uses heuristic for optimal performance  

### **3. Real-Time Statistics Panel**
- Algorithm name  
- Path length  
- Status: Path found / Not found  

### **4. Reset Functionality**
- Clears the grid and restores default state  

### **5. Modular Architecture**
- Separate classes for UI, grid, and algorithms  
- Easy to maintain and extend  


