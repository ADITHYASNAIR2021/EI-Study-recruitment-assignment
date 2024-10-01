# Astronaut Daily Schedule Organizer

A console-based Java application designed to help astronauts organize their daily schedules. The application allows users to add, remove, view, and manage tasks with features like conflict resolution based on priority levels and a logging system for tracking application usage and errors.

---

## Table of Contents

- [Features](#features)
- [Design Patterns and Principles](#design-patterns-and-principles)
- [Class Structure](#class-structure)
  - [Main](#main)
  - [LoggerManager](#loggermanager)
  - [ScheduleManager](#schedulemanager)
  - [Task](#task)
  - [TaskFactory](#taskfactory)
  - [PriorityLevel](#prioritylevel)
  - [InvalidTimeException](#invalidtimeexception)
  - [Observer](#observer)
  - [UserNotification](#usernotification)
- [Usage Instructions](#usage-instructions)
  - [Compiling the Application](#compiling-the-application)
  - [Running the Application](#running-the-application)
  - [Available Commands](#available-commands)
- [Examples](#examples)
- [Future Enhancements](#future-enhancements)
- [Additional Information](#additional-information)
- [Contact](#contact)

---

## Features

- **Add Tasks**: Schedule new tasks with descriptions, start time, end time, and priority levels.
- **Remove Tasks**: Delete existing tasks by description.
- **View Tasks**: Display all scheduled tasks sorted by start time.
- **Edit Tasks**: Modify existing tasks.
- **Mark Tasks as Completed**: Update task status to completed.
- **View Tasks by Priority**: Filter and view tasks based on priority levels.
- **Conflict Resolution**: Handles task conflicts with priority consideration and allows overriding of lower-priority tasks.
- **Logging System**: Logs application usage and errors, and allows viewing logs during the session.
- **Exception Handling**: Gracefully handles invalid inputs and exceptions.

---

## Design Patterns and Principles

- **Singleton Pattern**: Used in `ScheduleManager` to ensure a single instance manages all tasks.
- **Factory Pattern**: Implemented in `TaskFactory` to create `Task` objects.
- **Observer Pattern**: Used to notify users of task conflicts via the `Observer` interface and `UserNotification` class.
- **SOLID Principles**: Applied throughout the codebase to ensure clean, maintainable, and extensible code.

---

## Class Structure

### Main

**File**: `Main.java`

**Description**: The entry point of the application. Handles user interactions, and commands, and integrates the logging system.

**Key Methods**:

- `main(String[] args)`: Initializes the application and handles the main loop for user commands.
- `processCommand(String command, Scanner scanner)`: Processes user commands and directs to appropriate methods.
- Command methods: `addTask`, `removeTask`, `editTask`, `markTask`, `viewByPriority`, `viewLogs`, `displayHelp`.

---

### LoggerManager

**File**: `LoggerManager.java`

**Description**: Manages the logging system, including file and in-memory logs for the current session.

**Key Methods**:

- `getLogger()`: Returns the configured `Logger` instance.
- `getInMemoryLogs()`: Retrieves the logs stored in memory for the current session.

---

### ScheduleManager

**File**: `ScheduleManager.java`

**Description**: A singleton class that manages all tasks. Handles adding, removing, editing tasks, and conflict resolution based on priority levels.

**Key Methods**:

- `addTask(Task newTask)`: Adds a new task with conflict checking and resolution.
- `removeTask(String description)`: Removes a task based on its description.
- `editTask(String oldDescription, Task newTask)`: Edits an existing task.
- `markTaskAsCompleted(String description)`: Marks a task as completed.
- `viewTasks()`: Displays all tasks sorted by start time.
- `viewTasksByPriority(PriorityLevel priority)`: Displays tasks filtered by priority.
- `addObserver(Observer observer)`: Adds an observer for notifications.

---

### Task

**File**: `Task.java`

**Description**: Represents a task with properties like description, start time, end time, priority level, and completion status.

**Key Methods**:

- Getters and Setters for all properties.
- `toString()`: Returns a formatted string representation of the task.

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
