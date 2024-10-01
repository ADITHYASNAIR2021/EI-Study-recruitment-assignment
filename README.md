# 🛠️ Software Design and Astronaut Task Management System

## 🚀 Overview

This repository contains two coding exercises that assess both your software design knowledge and coding skills:

1. **Task 1**: A series of design pattern implementations to demonstrate common architectural approaches in software design.
2. **Task 2**: An **Astronaut Daily Schedule Organizer**, which evaluates problem-solving, CRUD (Create, Read, Update, Delete) implementation, and adherence to coding best practices.

---

## 💡 System Design and Common Patterns

### What is System Design?

System design focuses on defining the architecture and components of a software system to satisfy specific requirements. It's crucial to ensure scalability, maintainability, and efficiency. Patterns like **behavioral**, **structural**, and **creational** design patterns are important in organizing code to handle complex systems.

### Common Design Patterns Used in Task 1

| Pattern Type           | Example Used       | Description                                                                 |
|------------------------|--------------------|-----------------------------------------------------------------------------|
| **Behavioral**          | Observer Pattern   | Defines how objects communicate. Example: **Observer Pattern** for updates. |
| **Creational**          | Singleton Pattern  | Handles object creation. Example: **Singleton Pattern** for a single instance.|
| **Structural**          | Adapter Pattern    | Defines object composition. Example: **Adapter Pattern** for compatibility. |

---

## 🧑‍🚀 Task 2: Astronaut Daily Schedule Organizer

**Objective**: 
Create a console-based application that helps astronauts organize their daily tasks. This is a simple CRUD application that demonstrates task management, validation, and optimization principles.

### Why is this Task Important?

This task evaluates critical software development skills, including:
- **CRUD operations**: Creating, reading, updating, and deleting tasks.
- **Design Patterns**: Using patterns like **Singleton**, **Factory**, and **Observer**.
- **Error Handling**: Ensuring tasks don't overlap and inputs are validated.
- **Real-world Simulation**: Simulating task management for astronauts in a real-world context.

### ✨ Features

1. **Task Management**:
   - Add, remove, and view tasks with descriptions, start time, end time, and priority.
   - Validate that new tasks don't overlap.

2. **Design Patterns Used**:
   - **Singleton Pattern**: For global task schedule management.
   - **Factory Pattern**: To create task objects.
   - **Observer Pattern**: To notify users of task conflicts.

### ✅ Example Usage

- **Input**: `Add Task("Exercise", "07:00", "08:00", "High")`
- **Output**: `Task added successfully. No conflicts.`

- **Input**: `Add Task("Meeting", "09:00", "10:00", "Medium")`
- **Output**: `Task added successfully. No conflicts.`

- **Input**: `Add Task("Training", "09:30", "10:30", "High")`
- **Output**: `Error: Task conflicts with existing task "Meeting".`

---

## 🔧 Setup Instructions

To run this project locally:

1. Clone the repository.
2. Follow the code in the `Task1` directory for design pattern examples.
3. Use the `Task2` directory for the **Astronaut Daily Schedule Organizer** project.
4. Run the respective tasks and check the outputs.

---

## 📝 Conclusion

This repository demonstrates practical implementations of software design patterns and real-world task management for astronauts. The combination of these tasks showcases your understanding of both theoretical design concepts and coding proficiency.
