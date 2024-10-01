# 🚀 Astronaut Daily Schedule Organizer

A console-based Java application designed to help astronauts organize their daily schedules. The application allows users to add, remove, view, and manage tasks with features like conflict resolution based on priority levels and a logging system for tracking application usage and errors.

---

## 📋 Table of Contents

- [✨ Features](#-features)
- [📐 Design Patterns and Principles](#-design-patterns-and-principles)
- [🏗️ Class Structure](#-class-structure)
  - [Main](#main)
  - [LoggerManager](#loggermanager)
  - [ScheduleManager](#schedulemanager)
  - [Task](#task)
  - [TaskFactory](#taskfactory)
  - [PriorityLevel](#prioritylevel)
  - [InvalidTimeException](#invalidtimeexception)
  - [Observer](#observer)
  - [UserNotification](#usernotification)
- [🛠️ Usage Instructions](#-usage-instructions)
  - [🔧 Compiling the Application](#compiling-the-application)
  - [🚀 Running the Application](#running-the-application)
  - [📝 Available Commands](#available-commands)
- [📊 Examples](#-examples)
- [🔮 Future Enhancements](#-future-enhancements)
- [ℹ️ Additional Information](#-additional-information)
- [📞 Contact](#-contact)

---

## ✨ Features

- **➕ Add Tasks**: Schedule new tasks with descriptions, start time, end time, and priority levels.
- **🗑️ Remove Tasks**: Delete existing tasks by description.
- **👁️ View Tasks**: Display all scheduled tasks sorted by start time.
- **🛠️ Edit Tasks**: Modify existing tasks.
- **✅ Mark Tasks as Completed**: Update task status to completed.
- **🔍 View Tasks by Priority**: Filter and view tasks based on priority levels.
- **⚔️ Conflict Resolution**: Handles task conflicts with priority consideration and allows overriding of lower-priority tasks.
- **📜 Logging System**: Logs application usage and errors, and allows viewing logs during the session.
- **🚫 Exception Handling**: Gracefully handles invalid inputs and exceptions.

---

## 📐 Design Patterns and Principles

- **Singleton Pattern**: Ensures only one instance of the `ScheduleManager` manages all tasks.
- **Factory Pattern**: `TaskFactory` is used to create `Task` objects with input validation.
- **Observer Pattern**: Notifies users of task conflicts using the `Observer` interface and `UserNotification` class.
- **SOLID Principles**: Applied to ensure clean, maintainable, and extensible code throughout the project.

---

## 🏗️ Class Structure

| Class Name      | Description                                                             |
|-----------------|-------------------------------------------------------------------------|
| **Main**        | Entry point, processes user commands and integrates the logging system.  |
| **LoggerManager**| Manages the logging system for both in-memory and file-based logs.      |
| **ScheduleManager** | Singleton class that manages tasks and handles conflict resolution.  |
| **Task**        | Represents a task with details such as time, description, and priority.  |
| **TaskFactory** | Implements the Factory Pattern to create validated `Task` objects.       |
| **PriorityLevel**| Enumeration representing task priority levels (`HIGH`, `MEDIUM`, `LOW`).|
| **InvalidTimeException**| Custom exception class for handling invalid time inputs.         |
| **Observer**    | Interface for notifying users of task conflicts or changes.              |
| **UserNotification**| Implements the `Observer` interface to display notifications to users.|

---

### **Main** 🏁

- **File**: `Main.java`
- **Description**: Handles user interactions, command inputs, and logging integration.
- **Key Methods**: 
  - `main(String[] args)`
  - `processCommand(String command, Scanner scanner)`
  - Commands: `addTask`, `removeTask`, `editTask`, `markTask`, `viewByPriority`, `viewLogs`, `displayHelp`.

---

### **LoggerManager** 📝

- **File**: `LoggerManager.java`
- **Description**: Manages application logs.
- **Key Methods**: 
  - `getLogger()`
  - `getInMemoryLogs()`

---

### **ScheduleManager** 📅

- **File**: `ScheduleManager.java`
- **Description**: Manages tasks, handles conflict resolution based on priority levels, and notifies users.
- **Key Methods**: 
  - `addTask(Task newTask)`
  - `removeTask(String description)`
  - `editTask(String oldDescription, Task newTask)`
  - `markTaskAsCompleted(String description)`
  - `viewTasks()`
  - `viewTasksByPriority(PriorityLevel priority)`
  - `addObserver(Observer observer)`

---

### **Task** 📝

- **File**: `Task.java`
- **Description**: Represents a task object.
- **Key Methods**:
  - Getters and Setters for task properties.
  - `toString()`: Provides a string representation of the task.

---

### TaskFactory

**File**: `TaskFactory.java`

**Description**: Implements the Factory Pattern to create `Task` objects with input validation.

**Key Methods**:

- `createTask(String description, String startTimeStr, String endTimeStr, String priorityStr)`: Creates a new `Task` object after validating inputs.

---

### PriorityLevel

**File**: `PriorityLevel.java`

**Description**: An enumeration representing task priority levels (`HIGH`, `MEDIUM`, `LOW`).

---

### InvalidTimeException

**File**: `InvalidTimeException.java`

**Description**: A custom exception class for handling invalid time inputs.

---

### Observer

**File**: `Observer.java`

**Description**: An interface defining the method for notification updates.

**Key Methods**:

- `update(String message)`: The method is to be implemented by observers to receive notifications.

---

### UserNotification

**File**: `UserNotification.java`

**Description**: Implements the `Observer` interface to handle user notifications.

**Key Methods**:

- `update(String message)`: Displays notifications to the user.

---

## Usage Instructions

### Compiling the Application

1. Open a terminal in the directory containing the `.java` files.
2. Compile the Java files:

   ```bash
   javac *.java

### Running the Application

   ```bash
    java Main
```

### Available Commands

- **add**: Add a new task.
- **remove**: Remove an existing task.
- **view**: View all tasks.
- **edit**: Edit an existing task.
- **mark**: Mark a task as completed.
- **view priority**: View tasks by priority.
- **view logs**: View application logs.
- **help**: Display help message.
- **exit**: Exit the application.

## Examples

### Adding a Task

```plaintext
> add
Enter description: Morning Exercise
Enter start time (HH: MM): 07:00
Enter end time (HH: MM): 08:00
Enter priority (High, Medium, Low): High
Task added successfully. No conflicts.
```
### Viewing All Tasks

```plaintext
> view
07:00 - 08:00: Morning Exercise [HIGH]
```

### Removing a Task

```plaintext
> remove
Enter task description to remove: Morning Exercise
Task removed successfully.
```
### Viewing Tasks by Priority

```plaintext
> view priority
Enter priority level to view (High, Medium, Low): High
No tasks with priority HIGH
```

### Viewing Logs

```plaintext
> view logs
Session Logs:
[2024-03-29 10:35:00] [INFO   ] Task 'Morning Exercise' added successfully.
[2024-03-29 10:36:05] [INFO   ] Task 'Morning Exercise' removed successfully.
```
### Future Enhancements

- `Graphical User Interface (GUI)`: Implement a GUI using JavaFX to enhance user interaction.
- `Recurring Tasks`: Add functionality to support recurring tasks (daily, weekly, monthly).
- `Task Categories`: Introduce categories or tags for tasks to allow better organization.
- `Notifications and Reminders`: Implement a system to notify users of upcoming tasks.
- `Data Persistence`: Save tasks to a file or database to maintain the schedule between sessions.
- `User Authentication`: Support multiple users with personalized schedules.

### Additional Information

- `Time Format`: All times should be entered in 24-hour format (HH: MM).
- `Priority Levels`: Priority can be High, Medium, or Low. This affects conflict resolution.
- `Conflict Resolution`: When adding a task that conflicts with existing tasks:
- If the new task has a higher priority, you can choose to override the existing tasks.
- If the new task has an equal or lower priority, it will not be added, and you will be notified of the conflict.

### Contact

```
Adithya S Nair
adithyasnair2021@gmail.com
https://www.linkedin.com/in/adithya-s-nair/
```
