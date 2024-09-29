# Design Patterns Coding Exercises

## Overview

This project explores the use of **design patterns** to solve common software design challenges. The focus is on implementing six use cases using **Behavioral**, **Creational**, and **Structural** design patterns to demonstrate their application in real-world scenarios.

Design patterns provide templates for building software that is maintainable, scalable, and flexible by promoting best practices in object-oriented programming.

---

## Design Patterns Overview

### Behavioral Design Patterns

Behavioral patterns focus on communication between objects. They help define the interactions and flow of control between various entities in a system, abstracting the complexity of communication between them.

#### **Observer Pattern**

The **Observer Pattern** defines a one-to-many dependency between objects, so when one object changes state, all its dependents are notified and updated automatically.

- **Use Case**: This pattern is useful in event-driven systems, such as a notification system where multiple observers are updated when the subject's state changes.
- **Advantages**:
  - Promotes loose coupling between the subject and its observers.
  - Makes it easy to add or remove observers at runtime without modifying the subject.

#### **Strategy Pattern**

The **Strategy Pattern** allows the selection of an algorithm at runtime. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. 

- **Use Case**: When you need to choose between multiple algorithms (e.g., selecting between sorting algorithms based on data structure or size).
- **Advantages**:
  - Enables switching between algorithms without modifying the client.
  - Promotes adherence to the Open/Closed principle (open for extension, closed for modification).

---

### Creational Design Patterns

Creational patterns focus on the process of object creation. These patterns provide various ways to create objects while hiding the logic of the creation process, ensuring that systems are not tightly coupled with how their objects are created.

#### **Singleton Pattern**

The **Singleton Pattern** ensures that a class has only one instance and provides a global point of access to it.

- **Use Case**: This is typically used for resources that should have a single shared instance, such as a logger or configuration manager.
- **Advantages**:
  - Ensures that only one instance of a class is created.
  - Reduces memory usage and improves performance when a single instance suffices for the entire system.

#### **Factory Pattern**

The **Factory Pattern** defines an interface for creating objects but allows subclasses to alter the type of objects that will be created.

- **Use Case**: When the client doesn't need to know the exact class of the object being created (e.g., shapes or vehicles).
- **Advantages**:
  - Provides flexibility and reusability by abstracting the object creation logic.
  - Promotes loose coupling between object creation and client code.

---

### Structural Design Patterns

Structural patterns deal with the composition of classes or objects. These patterns help ensure that complex structures remain efficient and manageable by organizing objects and classes into larger compositions.

#### **Adapter Pattern**

The **Adapter Pattern** allows incompatible interfaces to work together by converting one interface into another. It acts as a bridge between two incompatible interfaces.

- **Use Case**: When you want to integrate an external library or API that does not match your required interface.
- **Advantages**:
  - Enables reuse of existing code by providing a way to work with incompatible interfaces.
  - Allows for the integration of third-party systems without modifying the original code.

#### **Facade Pattern**

The **Facade Pattern** provides a simplified interface to a complex subsystem. It hides the complexity of the subsystem by providing a unified interface for clients.

- **Use Case**: When interacting with a complex system like a multimedia library where clients only need access to simplified functionality.
- **Advantages**:
  - Reduces complexity for the client by hiding the details of the subsystem.
  - Promotes loose coupling between the client and the system.

---

## Project Description

This project implements six use cases that demonstrate the application of the following design patterns:

1. **Observer Pattern**: Implements a notification system where observers are notified of changes in the state of the subject.
2. **Strategy Pattern**: Implements a flexible algorithm selection system where the algorithm is chosen at runtime.
3. **Singleton Pattern**: Ensures a class (like a configuration manager or logger) has only one instance throughout the application lifecycle.
4. **Factory Pattern**: Demonstrates object creation where the client requests objects without needing to know the exact class type.
5. **Adapter Pattern**: Shows how to integrate incompatible interfaces by using an adapter.
6. **Facade Pattern**: Simplifies client interaction with a complex subsystem by providing a unified, simplified interface.

---

## Additional Considerations

### 1. **Code Modularity**

Each design pattern is implemented in a modular fashion, with separate classes for each use case. This ensures clean, organized code that is easy to understand and maintain.

### 2. **Scalability & Performance**

The code is designed to handle long-running processes where inputs are gathered from users over extended periods. It avoids inefficient practices like `while(true)` loops to ensure scalability and resource efficiency.

### 3. **Best Practices**

- **Logging**: Meaningful logs are used to track key execution steps.
- **Exception Handling**: Comprehensive error-handling mechanisms ensure smooth operation.
- **Defensive Programming**: The program validates inputs and handles edge cases to ensure robustness.
- **Global Standards**: The code adheres to global standards for object-oriented design, ensuring maintainable, reusable, and scalable software.

---

## Conclusion

This project showcases the power of design patterns in building scalable, maintainable, and flexible software solutions. By implementing **Behavioral**, **Creational**, and **Structural** patterns, this project demonstrates how design patterns can address common software design challenges, promoting best practices in software development.
