# Algorithim_visualizer

# Overview
This project is a Java-based visual path finder algorithm that uses the A* search algorithm to find the shortest path between two points on a map. It includes a graphical interface that displays the resulting path on the map.

# Problem Solved
Finding the shortest path between two points on a map is a common problem that has many practical applications, such as routing for delivery trucks or directing pedestrians through a city. The A* search algorithm is a popular choice for solving this problem because it is efficient and able to find optimal solutions in many cases.

# Solution
The A* search algorithm works by combining the benefits of two other search algorithms: Dijkstra's algorithm and a best-first search. It maintains a list of unexplored nodes (called the "open nodes") and a list of explored nodes (called the "checked nodes"). At each step, it selects the node with the lowest cost (as estimated by a heuristic function) from the open list and expands it by adding its neighbors to the open list.(For now this process is hidden but can be displayed to the user.) This process continues until the goal node is reached or there are no more nodes to explore. The user will begin this path finding through pressing the ESCAPE Key.

In this implementation, the heuristic function estimates the cost to reach the goal by assuming that the path will navigate around an obstacle (called "solid" nodes) from the start node to the goal.

# Installation
To install and run this project, you will need to have the following software installed on your computer:

Java 8 or higher
A Java Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA
Clone the repository to your local machine:

Copy code

git clone : https://github.com/ZhangKevin-hub/Algorithim_visualizer.git

Open the project in your IDE.

Run the Main.java file to launch the application.

# Usage
To use the path finder, follow these steps:

Press Escape to begin process.

The shortest path between the two points will be displayed on the map.

# Example Usage
Here is an example of the path finder in action:

<img width="1227" alt="Screenshot 2023-01-03 at 10 45 52 AM" src="https://user-images.githubusercontent.com/110786760/210392255-2c4e3c5f-0eed-462d-ab3b-980de2fb6a73.png">

# Dependencies
This project has the following dependencies:

Java Swing library for the graphical user interface

# Credits and References

A* search algorithm: https://en.wikipedia.org/wiki/A*_search_algorithm

Dijkstra's algorithm: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm

Best-first search: https://en.wikipedia.org/wiki/Best-first_search

# TODO:
Allow users to customize the start and goal points with custom input on a JPanel and customize walls.
