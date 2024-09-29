# Creational Design Patterns

## Overview

Creational design patterns deal with object creation mechanisms, optimizing the instantiation process. These patterns abstract the object creation process and ensure that objects are instantiated in a way that is flexible, reusable, and efficient.

### Patterns Implemented

1. **Singleton Pattern**:


   - Ensures that a class has only one instance and provides a global point of access to it.
   - Use Case: Managing system-wide resources like configuration managers or loggers.

2. **Factory Pattern**:

   - Provides an interface for creating objects without specifying the exact class to instantiate.
   - Use Case: A system that needs to create objects dynamically, such as a shape or vehicle factory.

### How to Test

1. Download the Singleton and Factory pattern implementations.
2. Make sure each pattern is in a separate folder with individual class files.
3. Compile and run the `SingletonPatternDemo` or `FactoryPatternDemo` class to check the implementation.
4. Observe the outputs to confirm that the Singleton pattern allows only one instance or that the Factory pattern creates objects based on client input.

### Example

Run the following in your terminal or IDE:

```bash
javac SingletonPatternDemo.java
java SingletonPatternDemo

javac FactoryPatternDemo.java
java FactoryPatternDemo

