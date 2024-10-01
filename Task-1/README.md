# 🛠️ Design Patterns Coding Exercises

## 🚀 Overview

This project explores the use of **design patterns** to solve common software design challenges. The focus is on implementing six use cases using **Behavioral**, **Creational**, and **Structural** design patterns to demonstrate their application in real-world scenarios.

Design patterns provide templates for building software that is maintainable, scalable, and flexible by promoting best practices in object-oriented programming.

---

## 💡 Design Patterns Overview

| Pattern Type        | Pattern             | Description                                                                 |
|---------------------|---------------------|-----------------------------------------------------------------------------|
| **Behavioral**       | **Observer Pattern** | Defines how objects communicate and react to changes in state.               |
|                     | **Strategy Pattern** | Encapsulates interchangeable algorithms, enabling flexibility at runtime.    |
| **Creational**       | **Singleton Pattern**| Ensures a class has only one instance and provides global access to it.      |
|                     | **Factory Pattern**  | Provides an interface to create objects without exposing the creation logic. |
| **Structural**       | **Adapter Pattern**  | Converts one interface into another to work with incompatible interfaces.    |
|                     | **Facade Pattern**   | Simplifies the interaction with complex subsystems through a unified interface. |

---

### 🔄 Behavioral Design Patterns

#### **Observer Pattern** 👀

The **Observer Pattern** defines a one-to-many dependency between objects, so when one object changes state, all its dependents are notified and updated automatically.

- **Use Case**: Useful in event-driven systems like a notification service.
- **Advantages**:
  - Promotes loose coupling between the subject and its observers.
  - Allows dynamic addition/removal of observers at runtime.

#### **Strategy Pattern** 🔄

The **Strategy Pattern** allows for runtime selection of an algorithm. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. 

- **Use Case**: When multiple algorithms can be chosen at runtime, like sorting algorithms based on data type.
- **Advantages**:
  - Allows flexibility by enabling algorithm switching without modifying the client.
  - Follows the **Open/Closed Principle** (open for extension, closed for modification).

---

### 🏗️ Creational Design Patterns

#### **Singleton Pattern** 🔑

The **Singleton Pattern** ensures that a class has only one instance and provides a global point of access to it.

- **Use Case**: Resource management (e.g., a configuration manager, logging system).
- **Advantages**:
  - Guarantees only one instance of a class.
  - Reduces memory usage and improves performance.

#### **Factory Pattern** 🏭

The **Factory Pattern** defines an interface for creating objects, but allows subclasses to decide which class to instantiate.

- **Use Case**: When the client doesn’t need to know the exact class of the object being created (e.g., shape or vehicle factories).
- **Advantages**:
  - Promotes flexibility by decoupling object creation logic from the client.
  - Follows the **Single Responsibility Principle**.

---

### 🧩 Structural Design Patterns

#### **Adapter Pattern** 🔌

The **Adapter Pattern** allows incompatible interfaces to work together by converting one interface into another. It acts as a bridge between different interfaces.

- **Use Case**: When integrating a third-party library or API that doesn’t match the required interface.
- **Advantages**:
  - Enables reuse of existing code with incompatible interfaces.
  - Simplifies integration without modifying existing code.

#### **Facade Pattern** 🏠

The **Facade Pattern** provides a simplified interface to a complex subsystem. It hides the complexity of the subsystem from the client.

- **Use Case**: Interacting with a complex system like a multimedia library, where clients only need core functionalities.
- **Advantages**:
  - Reduces complexity by offering a simple interface.
  - Promotes loose coupling between the client and the system.

---

## 📋 Project Description

This project implements six use cases that demonstrate the following design patterns:

1. **Observer Pattern**: A notification system where observers are notified of changes in the subject's state.
2. **Strategy Pattern**: A flexible system that allows runtime selection of algorithms.
3. **Singleton Pattern**: A globally accessible class that guarantees a single instance (e.g., a configuration manager).
4. **Factory Pattern**: A flexible object creation system where the client requests objects without knowing their exact class.
5. **Adapter Pattern**: A system that allows integration of incompatible interfaces using an adapter.
6. **Facade Pattern**: A simplified interface to a complex system, reducing client complexity.

---

## ⚙️ Additional Considerations

### 1. **Code Modularity** 🗂️

Each design pattern is implemented in a modular fashion, with separate classes for each use case. This ensures clean, organized, and maintainable code.

### 2. **Scalability & Performance** 🚀

The code is designed to handle long-running processes, efficiently managing user inputs without relying on inefficient practices like `while(true)` loops. This ensures both scalability and performance.

### 3. **Best Practices** 🔍

- **Logging**: Meaningful logs track key execution steps.
- **Exception Handling**: Comprehensive error-handling ensures smooth operation.
- **Defensive Programming**: Input validation and edge case handling ensure robustness.
- **Global Standards**: The code adheres to global standards for object-oriented design, ensuring maintainability and reusability.

---

## 📝 Conclusion

This project highlights the power of design patterns in building scalable, maintainable, and flexible software solutions. By implementing **Behavioral**, **Creational**, and **Structural** patterns, this project demonstrates how design patterns can address common software design challenges, promoting best practices in software development.
