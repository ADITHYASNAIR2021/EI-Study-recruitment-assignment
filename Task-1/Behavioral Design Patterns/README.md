# Behavioral Design Patterns

## Overview

Behavioral design patterns focus on communication between objects. They help define how objects interact and exchange information, managing responsibilities between different classes and ensuring that the communication flow is handled effectively.

### Patterns Implemented

1. **Observer Pattern**:

   - Allows objects (observers) to be notified of changes in another object (subject).
   - Use Case: Notification system where multiple modules receive updates when a central module's state changes.

2. **Strategy Pattern**:
   - Allows switching between different algorithms or strategies at runtime.
   - Use Case: A flexible system that chooses between multiple algorithms (e.g., different sorting strategies based on data structure size).

### How to Test

1. Clone the repository or download the Observer and Strategy pattern implementations.
2. Ensure the code is organized in separate files and classes.
3. Compile and run the `ObserverPatternDemo` or `StrategyPatternDemo` class to verify the implementation.
4. Check the console output to ensure that the observers are being updated or that the correct strategy is being executed.

### Example

Run the following in your terminal or IDE:

```bash
javac ObserverPatternDemo.java
java ObserverPatternDemo

javac StrategyPatternDemo.java
java StrategyPatternDemo

